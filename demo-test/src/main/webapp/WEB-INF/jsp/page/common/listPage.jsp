<!DOCTYPE HTML>
<%@ page  language="java" pageEncoding="UTF-8"%>
<script type="text/javascript">
	function nextPage() {
		var lastPage = parseInt($("#lastPageNo").val());
		var currentPage = parseInt($("#pageNo").val());
		if (currentPage < lastPage) {
			$("#pageNo").val(currentPage + 1);
			pageQuery();
		}
	}

	function previousPage() {
		var currentPage = parseInt($("#pageNo").val());
		if (currentPage > 1) {
			$("#pageNo").val(currentPage - 1);
			pageQuery();
		}
	}

	function firstPage() {
		var currentPage = parseInt($("#pageNo").val());
		if (currentPage != 1) {
			$("#pageNo").val(1);
			pageQuery();
		}
	}

	function lastPage() {
		var currentPage = parseInt($("#pageNo").val());
		var lastPage = parseInt($("#lastPageNo").val());
		if (currentPage != lastPage) {
			$("#pageNo").val(lastPage);
			pageQuery();
		}
	}

	function selectPage() {
		var currentPage = parseInt($("#pageNo").val());
		var selectPageNo = $("#pageSelect").val();
		if (currentPage != selectPageNo) {
			$("#pageNo").val(selectPageNo);
			pageQuery();
		}
	}
</script>

<!-- 每页显示函数-->
<div class="col-sm-4 col-md-4">
	<div class="form-inline">
		<div class="form-group">
			<label for="pageSize">每页：</label> 
			<select class="form-control input-sm" id="pageSize" name="pageSize"  onchange="$('#pageNo').val(1);pageQuery();">
				<option value="10" <c:if test="${page.pageSize==10}"> selected </c:if>>10</option>
				<option value="15" <c:if test="${page.pageSize==15}"> selected </c:if>>15</option>
				<option value="20" <c:if test="${page.pageSize==20}"> selected </c:if>>20</option>
				<option value="50" <c:if test="${page.pageSize==50}"> selected </c:if>>50</option>
			</select> 
			<label for="pageSize">行</label> 
		</div>
	</div>
</div>

<!-- page -->
<div class="col-sm-8 col-md-8 " style="height:10px;">
	<div class="form-inline pull-right">
		<input type="hidden" id="pageNo" name="pageNo" value="${page.pageNo}" />
		<input type="hidden" id="lastPageNo" value="${page.lastPage}" /> 
		<input type="hidden" id="totalPageNo" value="${page.totalPages}" />
		<div class="form-group">
			<div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
				<div class="btn-group">
					<!-- 这一行导致产生了滚动条，//TODO:待解决 -->
					<button type="button" class="btn btn-white btn-sm" onclick="firstPage();">首页</button>
					<button type="button" class="btn btn-white btn-sm" onclick="previousPage();">上一页</button>
					<button type="button" class="btn btn-white btn-sm" onclick="nextPage();">下一页</button>
					<button type="button" class="btn btn-white btn-sm" onclick="lastPage();">末页</button>
				</div>
				<div class="btn-group" role="group" aria-label="Second group">
					<label for="currentpage_combo">当前第</label> 
					<select id="pageSelect" class="form-control input-sm" onchange="selectPage();">
						<c:forEach var="x" begin="1" end="${page.totalPages}">
							<option value="${x}"
								<c:if test="${page.pageNo==x}"> selected </c:if>>${x}</option>
						</c:forEach>
					</select> 
					<label for="currentpage_combo">页</label>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- end page -->


