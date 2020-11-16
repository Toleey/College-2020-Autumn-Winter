
	$(document).ready(
		getNews6()
	);
	function clickdel(){
		return confirm("删除请点击确认");
	}
	function getNews6(){
		$.getJSON("../util/news_control","opr=backstageNewsList",showNews);
	}
	function showNews(data){
		$newsArray = $(data);
		$newsList = $(".classlist");
		$newsArray.each(function (){
			$newsList.append(
				"<li>"+this.ntitle+"<span> 作者： &#160;&#160;&#160;&#160;"+this.nauthor+"<a href='../util/news_control?opr=updateNews&nid="+this.nid+"'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control?opr=deleteNews&nid="+this.nid+"' onclick='return clickdel()'>删除</a> </span> </li>"
			)
		})
	}

	//jQuery的load方法，获得新闻后端的html片段组成的字符串并加载到当前的html元素中
	// 用途:主要用于在某个html中加载后端的html片段字符串  默认方法get，传对象用post方法，加一个post就行了
	function getNews5(){
		alert(1);
		$(".classlist").load("../util/news_control","opr=backstageNewsList");
		alert(2);
	}

	function getNews4(){

		$.ajax({
			"url"      :"../util/news_control",
			"type"     :"get",
			"data"     :"opr=backstageNewsList",
			"dataType" :"text",
			"success"  :function (newsJsonArray){
				//console.log(newsJsonArray)
				$newsArray = $(newsJsonArray);//变成jQuery的对象
				//console.log($newsArray)
				$newsList = $(".classlist");
				$newsList.append($newsArray)

			},
			"error"    :function (error){
				console.log(error)
			}
		});


	}

	function getNews3(){
		$.getJSON("../util/news_control","opr=backstageNewsList",showNews);
	}



	function getNews2(){
		$.get("../util/news_control", "opr=backstageNewsList", receiveNews);
	}
	function receiveNews(newsJsonArray){
		var newsJson = eval('[' + newsJsonArray + ']');//text转换成json对象
		$newsArray = $(newsJson);//变成jQuery的对象
		console.log($newsArray)
		$newsList = $(".classlist");
		$newsArray.each(function (){
			$newsList.append(
				"<li>"+this.ntitle+"<span> 作者： &#160;&#160;&#160;&#160;"+this.nauthor+"<a href='../util/news_control?opr=updateNews&nid="+this.nid+"'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control?opr=deleteNews&nid="+this.nid+"' onclick='return clickdel()'>删除</a> </span> </li>"
			)
		})
	}

	function getNews(){

		$.ajax({
			"url"      :"../util/news_control",
			"type"     :"get",
			"data"     :"opr=backstageNewsList",
			"dataType" :"json",
			"success"  :function (newsJsonArray){
				console.log(newsJsonArray)
				var newsJson = eval('[' + newsJsonArray + ']');//text转换成json对象
				//console.log(newsJson)
				$newsArray = $(newsJson);//变成jQuery的对象
				console.log($newsArray)
				$newsList = $(".classlist");
				$newsArray.each(function (){
					$newsList.append(
						"<li>"+this.ntitle+"<span> 作者： &#160;&#160;&#160;&#160;"+this.nauthor+"<a href='../util/news_control?opr=updateNews&nid="+this.nid+"'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control?opr=deleteNews&nid="+this.nid+"' onclick='return clickdel()'>删除</a> </span> </li>"
					)
				})


			},
			"error"    :function (error){
				console.log(error)
			}
		});


	}

