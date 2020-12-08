$(document).ready(
    getTopicList4()
)
function getTopicList4(){
    $.getJSON("../util/topic_control","opr=edittitle",showTopic);
}
function showTopic(data){
    $topicArray = $(data);
    $topicList = $(".classlist");
    $topicArray.each(
        function (){
            $topicList.append(
                "<li>"+this.tname+"&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;<a href='../util/topic_control?opr=showupd&tid="+this.tid+"'>修改</a> &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160; <a href='../util/topic_control?opr=deltopic&tid="+this.tid+"'>删除</a></li>"
            )
        }
    )
}

function getTopicList3(){
    $(".classList").load("../util/topic_control","opr=edittitle")
}

function getTopicList2(){
    $.get("../util/topic_control","opr=edittitle",showTopic2);
}
function showTopic2(topicJsonArray){
    $topicArray = $(topicJsonArray);
    $topicList = $(".classlist");
    $topicList.append($topicArray)
}

function getTopicList(){
    $.getJSON("../util/topic_control","opr=edittitle",showTopic);
}
