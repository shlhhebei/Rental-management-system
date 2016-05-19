<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
%>
<html>
  <head>
    <title></title>
    <meta http-equiv="refresh" content="0;url=<%=path%>/testJump.action">
  </head>
  <body>
  http-equiv
  META标签分两大部分：HTTP标题信息(HTTP-EQUIV)和页面描述信息(NAME)。
  ★HTTP-EQUIV
  HTTP-EQUIV类似于HTTP的头部协议，它回应给浏览器一些有用的信息，以帮助正确和精确地显示网页内容。常用的HTTP-EQUIV类型有：
  1、Content-Type和Content-Language (显示字符集的设定)
  说明：设定页面使用的字符集，用以说明主页制作所使用的文字已经语言，浏览器会根据此来调用相应的字符集显示page内容。
  注意：该META标签定义了HTML页面所使用的字符集为GB2132，就是国标汉字码。如果将其中的“charset=GB2312”替换成“BIG5”，则
        该页面所用的字符集就是繁体中文Big5码。当你浏览一些国外的站点时，IE浏览器会提示你要正确显示该页面需要下载xx语支持
        。这个功能就是通过读取HTML页面META标签的Content-Type属性而得知需要使用哪种字符集显示该页面的。如果系统里没有装相
        应的字符集，则IE就提示下载。其他的语言也对应不同的charset，比如日文的字符集是“iso-2022-jp ”，韩文的是“ks_c_5601”。
    Content-Type的Content还可以是：text/xml等文档类型；
    Charset选项：ISO-8859-1(英文)、BIG5、UTF-8、SHIFT-Jis、Euc、Koi8-2、us-ascii, x-mac-roman, iso-8859-2, x-mac-ce,iso-2022-jp,
                x-sjis, x-euc-jp,euc-kr, iso-2022-kr, gb2312, gb_2312-80, x-euc-tw, x-cns11643-1,x-cns11643-2等字符集；
                Content-Language的Content还可以是：EN、FR等语言代码。
  2、Refresh (刷新)
  说明：让网页多长时间（秒）刷新自己，或在多长时间后让网页自动链接到其它网页。
  注意：其中的5是指停留5秒钟后自动刷新到URL网址。
  3、Expires (期限)
  说明：指定网页在缓存中的过期时间，一旦网页过期，必须到服务器上重新调阅。
  注意：必须使用GMT的时间格式，或直接设为0(数字表示多少时间后过期)。
  4、Pragma (cach模式)
  说明：禁止浏览器从本地机的缓存中调阅页面内容。
  注意：网页不保存在缓存中，每次访问都刷新页面。这样设定，访问者将无法脱机浏览。
  5、Set-Cookie (cookie设定)
  说明：浏览器访问某个页面时会将它存在缓存中，下次再次访问时就可从缓存中读取，以提高速度。当你希望访问者每次都刷新你广告
        的图标，或每次都刷新你的计数器，就要禁用缓存了。通常HTML文件没有必要禁用缓存，对于ASP等页面，就可以使用禁用缓存，
        因为每次看到的页面都是在服务器动态生成的，缓存就失去意义。如果网页过期，那么存盘的cookie将被删除。
        21-Oct-98 16:14:21 GMT; path=/>
  注意：必须使用GMT的时间格式。
  6、Window-target (显示窗口的设定)
  说明：强制页面在当前窗口以独立页面显示。
  注意：这个属性是用来防止别人在框架里调用你的页面。Content选项：_blank、_top、_self、_parent。
  7、Pics-label (网页RSAC等级评定)
  说明：在IE的Internet选项中有一项内容设置，可以防止浏览一些受限制的网站，而网站的限制级别就是通过该参数来设置的。
  (PICS－1.1'http://www.rsac.org/ratingsv01.html'
  I gen comment 'RSACi North America Sever' by 'inet@microsoft.com'
  for 'http://www.microsoft.com' on '1997.06.30T14:21－0500' r(n0 s0 v0 l0))>
  注意：不要将级别设置的太高。RSAC的评估系统提供了一种用来评价Web站点内容的标准。用户可以设置Microsoft Internet Explorer
        （IE3.0以上）来排除包含有色情和暴力内容的站点。上面这个例子中的HTML取自Microsoft的主页。代码中的（n 0 s 0 v 0 l 0）
         表示该站点不包含不健康内容。级别的评定是由RSAC，即美国娱乐委员会的评级机构评定的，如果你想进一步了解RSAC评估系统的
         等级内容，或者你需要评价自己的网站，可以访问RSAC的站点：http://www.rsac.org/。
  8、Page-Enter、Page-Exit (进入与退出)
  说明：这个是页面被载入和调出时的一些特效。
  注意：blendTrans 是动态滤镜的一种，产生渐隐效果。另一种动态滤镜 RevealTrans 也可以用于页面进入与退出效果:
         Duration 表示滤镜特效的持续时间(单位：秒)
  Transition滤镜类型。表示使用哪种特效，取值为0-23。
  0 矩形缩小 1 矩形扩大 2 圆形缩小 3 圆形扩大 4 下到上刷新 5 上到下刷新 6 左到右刷新 7 右到左刷新 8 竖百叶窗 9 横百叶窗
  10 错位横百叶窗 11 错位竖百叶窗 12 点扩散 13 左右到中间刷新 14 中间到左右刷新 15 中间到上下 16 上下到中间 17 右下到左上
  18 右上到左下 19 左上到右下 20 左下到右上 21 横条 22 竖条 23 以上22种随机选择一种

  9、MSThemeCompatible (XP主题)
  说明：是否在IE中关闭 xp 的主题
  注意：关闭 xp 的蓝色立体按钮系统显示样式，从而和win2k 很象。
  10、IE6 (页面生成器)
  说明：页面生成器generator，是ie6
  注意：用什么东西做的，类似商品出厂厂商。
  11、Content-Script-Type (脚本相关)
  说明：这是近来W3C的规范，指明页面中脚本的类型。
  注意：
  ★NAME变量
  name是描述网页的，对应于Content（网页内容），以便于搜索引擎机器人查找、分类（目前几乎所有的搜索引擎都使用网上机器人自动查找meta值来给网页分类）。
  name的value值（name=）指定所提供信息的类型。有些值是已经定义好的。例如description(说明)、keyword(关键字)、refresh(刷新)等。还可以指定其他任意值，
     如：creationdate(创建日期) 、document ID(文档编号)和level(等级)等。
  name的content指定实际内容。如：如果指定level(等级)为value(值)，则Content可能是beginner(初级)、intermediate(中级)、advanced(高级)。
  1、Keywords (关键字)
  说明：为搜索引擎提供的关键字列表
  注意：各关键词间用英文逗号“,”隔开。META的通常用处是指定搜索引擎用来提高搜索质量的关键词。当数个META元素提供文档语言从属信息时，搜索引擎会使用lang
        特性来过滤并通过用户的语言优先参照来显示搜索结果
  2、Description (简介)
  说明：Description用来告诉搜索引擎你的网站主要内容。
  3、Robots (机器人向导)
  说明：Robots用来告诉搜索机器人哪些页面需要索引，哪些页面不需要索引。Content的参数有all、none、index、noindex、follow、nofollow。默认是all。
  注意：许多搜索引擎都通过放出robot/spider搜索来登录网站，这些robot/spider就要用到meta元素的一些特性来决定怎样登录。
  all：文件将被检索，且页面上的链接可以被查询；
  none：文件将不被检索，且页面上的链接不可以被查询；(和 noindex, no follow 起相同作用)
  index：文件将被检索；（让robot/spider登录）
  follow：页面上的链接可以被查询；
  noindex：文件将不被检索，但页面上的链接可以被查询；(不让robot/spider登录)
  nofollow：文件将不被检索，页面上的链接可以被查询。(不让robot/spider顺着此页的连接往下探找)

  4、Author (作者)
  说明：标注网页的作者或制作组
  用法：abc@163.com>
  注意：Content可以是：你或你的制作组的名字,或Email
  5、Copyright (版权)
  说明：标注版权
  6、Generator (编辑器)
  说明：编辑器的说明
  注意：Content=你所用编辑器
  7、revisit-after (重访)
  ★Head中的其它一些用法
  1、scheme (方案)
  说明：scheme can be used when name is used to specify how the value of content should be interpreted.
  2、Link (链接)
  说明：链接到文件
  注意：很多网站如果你把她保存在收件夹中后，会发现它连带着一个小图标，如果再次点击进入之后还会发现地址栏中也有个小图标。现在只要在你的页头加上这段话，
        就能轻松实现这一功能。 用来将目前文件与其它 URL 作连结，但不会有连结按钮，用於 标记间，
  3、Base (基链接)
  说明：插入网页基链接属性
  注意：你网页上的所有相对路径在链接时都将在前面加上“http://www.***.com/”。其中target=_blank是链接文件在新的窗口中打开，你可以做其他设置。将“_blank”改为
        “_parent”是链接文件将在当前窗口的父级窗口中打开；改为“_self”链接文件在当前窗口（帧）中打开；改为“_top”链接文件全屏显示。
  以上是META标签的一些基本用法，其中最重要的就是：Keywords和Description的设定。这两个语句可以让搜索引擎能准确的发现你，吸引更多的人访问你的站点!
  根据现在流行搜索引擎(Google，Lycos，AltaVista等)的工作原理，搜索引擎先派机器人自动在WWW上搜索，当发现新的网站时，便于检索页面中的Keywords和Description，
  并将其加入到自己的数据库，然后再根据关键词的密度将网站排序。
  </body>
</html>
