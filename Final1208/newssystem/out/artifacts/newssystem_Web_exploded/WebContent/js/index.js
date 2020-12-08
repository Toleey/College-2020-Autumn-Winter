$(document).ready(
    getDefaultNews(),
    getTopic()
);

//--------------------------------------主题新闻处理-----------------------------------------

//创建对象
var topicNewsPage = new Object();
topicNewsPage.pageIndex = 1
topicNewsPage.tid = 1 //暂存tid数据

function getTopic(){ //获得主题
    $.getJSON("../util/news_control","opr=getDisplayTopic",function (showTopic){
        $showTopic = $(showTopic);
        $showTopicList = $("#class_month");
        $showTopic.each(
            function (){
                $showTopicList.append(
                    "<a onclick='getTopicNews("+this.tid+")' id=\"topicNews\" href='#'><b>"+this.tname+"</b></a>" //传入主题编号
                )
            }
        )
    })
}

function getTopicNews(tid){//接收主题编号 显示主题页新闻
    $.getJSON("../util/news_control?topicNewsChoose=topicNews&ntid="+tid,"opr=topicNews",function (topicNews){
        //清除默认新闻翻页 只能这么写了。。。
        $topicNewsList = $("#classlist");
        $topicNewsList.empty();//empty移除被选元素内容
        $defaultNewsListPage = $("#page")
        $defaultNewsListPage.empty();

        $topicNews = $(topicNews);
        $topicNews.each(
            function (){
                $topicNewsList.append(
                    "<li><a href='../util/news_control?opr=readNews&nid="+this.nid+"'>"+ this.ntitle+"</a><span>"+this.ncreateDate+"</span></li>"
                )
            }
        )
        topicNewsPage.tid = tid;
        getTopicNewsPage();
    })
}

function getTopicNewsPage(){ //主题新闻翻页
    $showTopicListPage = $("#page");
    $showTopicListPage.append(
        "<a href=\"#\" onclick='topicNewsPageStart()'>首页</a>\n" +
        "<a href=\"#\" onclick='topicNewsPagePrevious()'>上一页</a>\n" +
        "<a href=\"#\" onclick='topicNewsPageNext()'>下一页</a>\n" +
        "<a href=\"#\" onclick='topicNewsPageEnd()'>末页</a>")
}

//四个翻页方法

function topicNewsPageStart(){
    topicNewsPage.pageIndex = 1;
    getTopicNewsByPage()
}
function topicNewsPagePrevious(){
    if (topicNewsPage.pageIndex > 1){
        topicNewsPage.pageIndex = topicNewsPage.pageIndex-1;
    }else{
        alert("前面没有了！")
    }
    getTopicNewsByPage()

}
function topicNewsPageNext(){

    $.get("../util/news_control?topicNewsChoose=pageCount&ntid="+topicNewsPage.tid+"&pageIndex2="+topicNewsPage.pageIndex,"opr=topicNews",function (topicPageCount) {
        var topicEndPage = Number(topicPageCount)

        if (topicNewsPage.pageIndex < topicEndPage){
            topicNewsPage.pageIndex = topicNewsPage.pageIndex+1;
        }else{
            alert("后面没有了！");
        }
        getTopicNewsByPage()

    })


}
function topicNewsPageEnd(){
    $.get("../util/news_control?topicNewsChoose=pageCount&ntid="+topicNewsPage.tid+"&pageIndex2="+topicNewsPage.pageIndex,"opr=topicNews",function (topicPageCount) {
        topicNewsPage.pageIndex = Number(topicPageCount)
        getTopicNewsByPage()

    })
}

function getTopicNewsByPage(){//接收主题编号 显示主题页新闻
    $.getJSON("../util/news_control?topicNewsChoose=topicNews&ntid="+topicNewsPage.tid+"&pageIndex2="+topicNewsPage.pageIndex,"opr=topicNews",function (topicNews){

        //清除默认新闻翻页 只能这么写了。。。
        $topicNewsList = $("#classlist");
        $topicNewsList.empty();//empty移除被选元素内容
        $defaultNewsListPage = $("#page")
        $defaultNewsListPage.empty();

        $topicNews = $(topicNews);
        $topicNews.each(
            function (){
                $topicNewsList.append(
                    "<li><a href='../util/news_control?opr=readNews&nid="+this.nid+"'>"+ this.ntitle+"</a><span>"+this.ncreateDate+"</span></li>"
                )
            }
        )
        getTopicNewsPage();
    })
}


//--------------------------------------默认新闻页面处理-----------------------------------------


//创建对象
var defaultNewsPage = new Object();
defaultNewsPage.pageIndex = 1
defaultNewsPage.pagCount = 1

function getDefaultNews(){//获得默认新闻
    $.getJSON("../util/news_control?opr=getDisplayNews","displayNewsChoose=newsList",function (defaultNews){
       $defaultNews = $(defaultNews);
       $defaultNewsList = $("#classlist");
       $defaultNews.each(
            function (){
                $defaultNewsList.append(
                    "<li><a href='../util/news_control?opr=readNews&nid="+this.nid+"'>"+ this.ntitle+"</a><span>"+this.ncreateDate+"</span></li>"
                )
            }
       )
        getDefaultNewsPage()

    })
}

//四个翻页方法
function defaultNewsPageStart(){
         defaultNewsPage.pageIndex = 1;
         getDefaultNewsByPage()
}
function defaultNewsPagePrevious(){
    if (defaultNewsPage.pageIndex > 1){
        defaultNewsPage.pageIndex = defaultNewsPage.pageIndex-1;
    }else if(
        alert("前面没有了！")
    )
    getDefaultNewsByPage()
}
function defaultNewsPageNext(){
         defaultNewsPage.pageIndex = defaultNewsPage.pageIndex+1;
         getDefaultNewsByPage()

    $.get("../util/news_control?opr=getDisplayNews&","displayNewsChoose=pageCount",function (pageCount) {
       var defaultNewsEndPage = Number(pageCount)
        if (defaultNewsPage.pageIndex < defaultNewsEndPage){
            defaultNewsPage.pageIndex = defaultNewsPage.pageIndex+1;
        }else{
            alert("后面没有了！");
        }
        getDefaultNewsByPage()
    })
}
function defaultNewsPageEnd(){
         $.get("../util/news_control?opr=getDisplayNews&","displayNewsChoose=pageCount",function (pageCount) {
             defaultNewsPage.pageIndex = Number(pageCount)
             getDefaultNewsByPage()
         })
}

function getDefaultNewsPage(){//默认新闻翻页
    $showTopicListPage = $("#page");
    $showTopicListPage.append(
        "<a href='#' onclick='defaultNewsPageStart()'>首页</a>\n" +
        "<a href='#' onclick='defaultNewsPagePrevious()'>上一页</a>\n" +
        "<a href='#' onclick='defaultNewsPageNext()'>下一页</a>\n" +
        "<a href='#' onclick='defaultNewsPageEnd()'>末页</a>"//pageCount 包含ajax请求，无法确定先后
    )
}


function getDefaultNewsByPage(){//获得默认新闻
    $.getJSON("../util/news_control?opr=getDisplayNews&pageIndex="+defaultNewsPage.pageIndex,"displayNewsChoose=newsList",function (defaultNews){

        $topicNewsList = $("#classlist");
        $topicNewsList.empty();//移除被选元素内容

        $defaultNews = $(defaultNews);
        $defaultNewsList = $("#classlist");
        $defaultNews.each(
            function (){
                $defaultNewsList.append(
                    "<li><a href='../util/news_control?opr=readNews&nid="+this.nid+"'>"+ this.ntitle+"</a><span>"+this.ncreateDate+"</span></li>"
                )
            }
        )

    })
}

function check(){
    var login_username = document.getElementById("uname");
    var login_password = document.getElementById("upwd");
    if(login_username.value == ""){
        alert("用户名不能为空！请重新填入！");
        login_username.focus();
        return false;
    }else if(login_password.value == ""){
        alert("密码不能为空！请重新填入！");
        login_password.focus();
        return false;
    }
    return true;
}

function focusOnLogin(){
    var login_username = document.getElementById("uname");
    login_username.focus();
}