<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QUEST</title>
</head>
<body>
${map}
<h1>${map.name}</h1>
<h1>${map.age}</h1>

<hr>
<h1>전달 받은 Map 객체 받아오기</h1>
<h1>${name}</h1>
<h1>${age}</h1>

<hr>
<p>AbstractMap : ${abstractMap}</p>
<p>EnumMap : ${enumMap}</p>
<p>HashMap : ${hashMap}</p>
<p>IdentityHashMap : ${identityHashMap}</p>
<p>LinkedHashMap : ${linkedHashMap}</p>
<p>TreeMap : ${treeMap}</p>
<p>WeakHashMap : ${weakHashMap}</p>


</body>
</html>