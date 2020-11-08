
	$(document).ready(
		getNews()
	);
	function clickdel(){
		return confirm("删除请点击确认");
	}
	function getNews(){  //王天琪

		$.ajax({
			"url"      :"../util/news_control",
			"type"     :"get",
			"data"     :"opr=backstageNewsList",
			"dataType" :"text",
			"success"  :function (newsJsonArray){
				//console.log(newsJsonArray)
				var newsJson = eval('[' + newsJsonArray + ']');//text转换成json对象
				//console.log(newsJson)
				$newsArray = $(newsJson);//变成jQuery的对象
				console.log($newsArray)
				var $newsList = $(".classlist");
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