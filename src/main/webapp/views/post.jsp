<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv='Content-Type' content="text/html"/>
    <title>bfstack</title>
    <style>
        header {
            background-color:black;
            color:white;
            text-align:center;
            padding:5px;
        }
        nav {
            line-height:15px;
            background-color:#eeeeee;
            width:30%;
            float:right;
            padding:5px;
        }
        section {
            width:65%;
            float:left;
            padding:25px;
        }
    </style>
</head>
<body>
<header>
    <h1>bfstack</h1>
</header>
<nav>
    <div id="hot-news-wrap"></div>
    <script>var yunModuleEnv = true;</script>
    <script src="https://img1.cache.netease.com/f2e/tie/yun/sdk/loader.js"></script>
    <script>
        var yunTieProductKey = "048ce60f5bfa4489a79078e48af06fe5";
        var yunHotNewsWrap = "hot-news-wrap";   //放置的DOM节点ID 或 样式类
        Tie.loader("aHR0cHM6Ly9hcGkuZ2VudGllLjE2My5jb20vZXh0ZW5kL2hvdF9uZXdzX3NjcmlwdC5odG1s", true);
    </script>
</nav>

<section>
    <!-- 中间文章详情 -->
    <div>
        <label class="article-title" style="font-style: italic;font-size: 24px;">${post.title}</label>
        <!-- 文章内容 -->
        <article>
            ${post.content}
        </article>

        <div id="cloud-tie-wrapper" class="cloud-tie-wrapper"></div>
        <script>
            var cloudTieConfig = {
                url: document.location.href,
                sourceId: ${post.id},
                productKey: "048ce60f5bfa4489a79078e48af06fe5",
                target: "cloud-tie-wrapper"
            };
        </script>
        <script src="https://img1.cache.netease.com/f2e/tie/yun/sdk/loader.js"></script>
    </div>
</section>
<footer>
    Copyright bfstack.com
</footer>
</body>
</html>
