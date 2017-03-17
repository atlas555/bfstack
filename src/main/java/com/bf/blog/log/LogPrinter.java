package com.bf.blog.log;

import java.util.Timer;
import java.util.TimerTask;

public abstract class LogPrinter {
	
    private boolean isBatch = false;
    private static final long MAX_OUTPUT_TIME = 500;
    private static final long DEFUALT_INTERVAL = 3000;
    private StringBuffer writeBuffer = new StringBuffer();
    private Timer timer = null;
    
    private void setTimer(){
        final Long writeInterval = DEFUALT_INTERVAL;
        long time = writeInterval - MAX_OUTPUT_TIME;
        long start = time - System.currentTimeMillis() % (writeInterval);
        if (start < 0) {
            start += writeInterval;
        }
        timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                while (System.currentTimeMillis() % writeInterval < writeInterval-MAX_OUTPUT_TIME) {}
                synchronized(writeBuffer) {
                    if(writeBuffer.length()>0){
                    	doLog(writeBuffer.toString());
                        writeBuffer.delete(0, writeBuffer.length());
                    }
                }
                while (System.currentTimeMillis() % writeInterval > writeInterval-MAX_OUTPUT_TIME) {
                }
            }
        }, start, time);
    }
    
    public void print(String log) {
        if(isBatch){
            synchronized(writeBuffer) {
            	if(writeBuffer.length()>0){
            		writeBuffer.append("\n");
            	}
                writeBuffer.append(log);
            }
        }else{
        	doLog(log);
        }
    }
    
    public void print(LogParas logParas) {
    	doLog(logParas.toText());
    }
    
    public void setBatch(){
        isBatch = true;
        setTimer();
    }
    
    public void unsetBatch(){
        isBatch = false;
        if(timer != null){
            timer.cancel();
            timer = null;
        }
    }
    
    abstract protected void doLog(String log);
}
