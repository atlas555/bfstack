<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-type" content="text/html;charset=utf-8"/>
    <title>bfstack</title>
    <link rel="stylesheet" href="../style/css/theme.css"/>
    <link rel="stylesheet" href="../style/css/main.css"/>
    <script type="text/javascript" src="https://img1.cache.netease.com/f2e/tie/yun/sdk/loader.js"></script>
    <script type="text/javascript" src="../style/js/main.js"></script>
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
    <label>${post.title}</label>
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
</section>
<footer>
    bfstack welcome
</footer>
</body>
</html>
