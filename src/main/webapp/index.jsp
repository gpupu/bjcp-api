<html>
<body>
<h1>BJCP API</h1>
<h2>What is this?</h2>
<p>
	This is a personal project that provides an API from the last 2015 BJCP style guidelines. BJCP API will provide some logic in order to 'search' by different attributes inside every style.
</p>
<p>
	Such features will provide a powerful base for different applications. Imagine, for example, a recommended system of which styles could you prefer.
</p>

<h2>Sources</h2>
<p>
	Information you could retrieve, runs over info scraped by <a href="https://github.com/gthmb/bjcp-2015-json">this github project</a> 
</p>

<h2>Future / TODO</h2>
<ul>
  <li>Work over more 'search' features</li>
  <li>XML support</li>
  <li>Clean index page (based on Markdown)</li>
  <li>2008 BJCP style guidelines support</li>
  <li>Shown scraped translations from <a href="http://www.bjcp.org/international.php">BJCP site</a></li>
  <li>Standarize retrieved information into a same format</li>
</ul>

<h2>How to use?</h2>
<h3>Search for a Category</h3>
<p> Try for using <a href="${pageContext.request.contextPath}/2015?category=3">"${pageContext.request.contextPath}/2015?category=3</a> </p>

<h3>Search for a Subcategory</h3>

<p> Try for using <a href="${pageContext.request.contextPath}/2015?subcategory=3C">"${pageContext.request.contextPath}"/2015?subcategory=3C</a></p>
</body>
</html>
