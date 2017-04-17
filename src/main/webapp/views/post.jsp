<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>bfstack</title>
    <style>
        header {
            background-color:black;
            color:white;
            text-align:center;
            padding:5px;
        }
        nav {
            line-height:30px;
            background-color:#eeeeee;
            height:300px;
            width:100px;
            float:left;
            padding:5px;
        }
        section {
            width:350px;
            float:left;
            padding:10px;
        }
        footer {
            background-color:black;
            color:white;
            clear:both;
            text-align:center;
            padding:5px;
        }
    </style>
</head>
<body>
<div>
    <header>
        <h1>bfstack</h1>
    </header>
    <nav style="float: right;width: 30%">
        <div id="hot-news-wrap"></div>
        <script>var yunModuleEnv = true;</script>
        <script src="https://img1.cache.netease.com/f2e/tie/yun/sdk/loader.js"></script>
        <script>
            var yunTieProductKey = "048ce60f5bfa4489a79078e48af06fe5";
            var yunHotNewsWrap = "hot-news-wrap";   //放置的DOM节点ID 或 样式类
            Tie.loader("aHR0cHM6Ly9hcGkuZ2VudGllLjE2My5jb20vZXh0ZW5kL2hvdF9uZXdzX3NjcmlwdC5odG1s", true);
        </script>
    </nav>

    <section style="width: 65%;padding: 25px">
        <!-- 中间文章详情 -->
        <div>
            <label class="article-title" style="font-style: italic;font-size: 24px;">${post.title}</label>
            <!-- 文章内容 -->
            <article>
                ${post.content}
            </article>

            <div id="cloud-tie-wrapper" class="cloud-tie-wrapper"></div>
        </div>
        <script>
            var cloudTieConfig = {
                url: document.location.href,
                sourceId: ${post.id},
                productKey: "048ce60f5bfa4489a79078e48af06fe5",
                target: "cloud-tie-wrapper"
            };
        </script>
        <script src="https://img1.cache.netease.com/f2e/tie/yun/sdk/loader.js"></script>
    </section>
    <footer>
        Copyright bfstack.com
    </footer>
</div>
</body>
</html>
