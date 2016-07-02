document.addEventListener("DOMContentLoaded", function() {

	//DOM load, getting value from a Tag
	var screenselect = document.querySelector("ul#selectscreen");
	console.log(screenselect);
	var links = screenselect.getElementsByTagName("a");
	console.log(links);
	//whenever click dots, images are changed and dot has color when it is activated
	for (var i = 0; i < links.length; i++) {
		links[i].onclick = function() {
			console.log("Link clicked");
			//image change
			var source = this.getAttribute("href");
			console.log(source);
			var placeholder = document.getElementById("screen_image");
			console.log(placeholder);
			placeholder.setAttribute("src", source);
			var linkcontrol = document.getElementById("showscreen");
			var reflink = this.getAttribute("link");
			console.log(reflink);
			linkcontrol.setAttribute("href", reflink);
			console.log("done");
			//text change
			var text1 = this.getAttribute("context1");
			console.log(text1);
			var paragraph1 = document.getElementById("description1");
			console.log(paragraph1);
			paragraph1.firstChild.nodeValue = text1;
			var text2 = this.getAttribute("context2");
			console.log(text2);
			var paragraph2 = document.getElementById("description2");
			console.log(paragraph2);
			paragraph2.firstChild.nodeValue = text2;
			var title = this.getAttribute("title");
			linkcontrol.setAttribute("title", title);
			//dot change
			for (var i = 0; i < links.length; i++) {
				links[i].firstChild.nodeValue = "○";
			}
			this.firstChild.nodeValue = "●";
			return false;
		}
	}
});
