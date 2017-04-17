<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-type" content="text/html;charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black"/>
    <title>bfstack</title>
    <link rel="stylesheet" href="../style/css/theme.css"/>
    <link rel="stylesheet" href="../style/css/main.css"/>
    <script type="text/javascript" src="https://img1.cache.netease.com/f2e/tie/yun/sdk/loader.js"></script>
    <script type="text/javascript" src="../style/js/main.js"></script>
    <style>
        html,
        body {
            font-size: 50px;
        }
    </style>
</head>
<body>
<header>
    <h1>bfstack</h1>
</header>
<nav>
    <div id="hot-news-wrap"></div>
</nav>

<section>
    <title>${post.title}</title>>
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
</section>
</body>
</html>
