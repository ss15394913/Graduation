<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.Map"
	import="java.util.HashMap"
	import="java.util.ArrayList"
	import="bean.ProductInformationBean"
	%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="ja">
	<head>
		<meta charset="UTF-8">
		<title>This is addcart</title>
		
		<script>
		</script>
		
		<style>
			#img{
				width:100px;
				height:100px;
			}
		</style>
		
	</head>
	<body >

		<p>${sessionScope.str}</p>
			<c:forEach var="product" items="${cart}">
				<section>
					${product.productId}
					${product.productName}
					${product.productPrice}
					${product.productSize}
					${product.productColor}
					${product.count}
					<img id ="img" src="${pageContext.request.contextPath}/images/${product.productImagePath}" />
					<br>
					<form action="${pageContext.request.contextPath}/front/editcart" method="post">
						<input type="hidden" name="productid" value="${product.productId}">
						<input type="number" name="itemcount" value="5">注文数
						<input type="submit" value="注文数を変更">
					</form>
					<form action="${pageContext.request.contextPath}/front/deletecart" method="post">
						<input type="hidden" name="productid" value="${product.productId}">商品ID
						<input type="submit" value="商品をカートから削除">
					</form>
				</section>
			</c:forEach>
		<a href="${pageContext.request.contextPath}/front/top">top</a><br>
	</body>
</html>