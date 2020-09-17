<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글등록</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/common/header.jsp"/>

	<main role="main">
	  <div class="container marketing">
	    <div class="row">
	      <div class="col-lg-10">
			<form:form modelAttribute="bbsEntity" method="post" class="form-horizontal">
				<div class="form-group">
					<label for="title" class="col-sm-2 control-label">title</label>
					<form:input path="title" class="form-control" placeholder="Enter title" value=""/>
				</div>
				<div class="form-group">
					<label for="contents" class="col-sm-2 control-label">contents</label>
					<form:input path="contents" class="form-control" placeholder="Enter contents" value="asd"/>
				</div>
				<div class="form-group">
					<label for="categorySeq" class="col-sm-2 control-label">categorySeq</label>
					<form:input path="categorySeq" class="form-control" placeholder="Enter categorySeq" value=""/>
				</div>
				<div class="form-group">
					<label for="useYn" class="col-sm-2 control-label">사용여부</label>
					<label class="radio-inline">
						<form:radiobutton path="useYn" label="Y" value="Y"/>
					</label>
					<label class="radio-inline">
						<form:radiobutton path="useYn" label="N" value="N"/>				
					</label>
				</div>
				<button  class="btn btn-primary">등록</button>
			</form:form>
			
					        
	      </div><!-- /.col-lg-10 -->
	    </div><!-- /.row -->
	  </div><!-- /.container -->
	</main>
	
<script type="text/javascript">

</script>
</body>
</html>