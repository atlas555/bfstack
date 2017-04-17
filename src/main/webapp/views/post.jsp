<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${post.title}/></title>
</head>
<body>
<div class="divOut">
    <div class="top"></div>
    <div class="bottom">
        <!-- 中间文章详情 -->
        <div id="main" style="width:755px;margin-left: 0;">
            <label class="article-title">${post.title}/></label>
            <!-- 文章内容 -->
            <article>
                ${post.content}
            </article>
        </div>
    </div>
    <div id="cloud-tie-wrapper" class="cloud-tie-wrapper"></div>
    <script>
        var cloudTieConfig = {
            url: document.location.href,
            sourceId: "",
            productKey: "048ce60f5bfa4489a79078e48af06fe5",
            target: "cloud-tie-wrapper"
        };
    </script>
    <script src="https://img1.cache.netease.com/f2e/tie/yun/sdk/loader.js"></script>
    <div class="page-bottom">
        © 2017 bfstack.com All Rights Reserved
    </div>
</div>
</body>
</html>