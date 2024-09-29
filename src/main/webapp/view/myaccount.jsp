<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<div class="main">
	<div class="container">
		<div class="col-md-9 col-sm-9">
			<div class="content-form-page">
				<div class="row">
					<div class="col-md-7 col-sm-7">
						<form action="myaccount" method="post"
							enctype="multipart/form-data"
							class="form-horizontal form-without-legend" role="form">
							<h2>Thông Tin Tài Khoản Của Bạn</h2>

							<!-- Hiển thị thông báo nếu có -->
							<c:if test="${not empty requestScope.message}">
								<div class="alert alert-info">${requestScope.message}</div>
							</c:if>

							<c:choose>
								<c:when test="${sessionScope.account != null}">
									<div class="account-details">
										<h3>Xin chào, ${sessionScope.account.fullname}!</h3>
										<p>
											<strong>Full Name:</strong> ${sessionScope.account.fullname}
										</p>
										<p>
											<strong>Phone:</strong> ${sessionScope.account.phone}
										</p>
										<c:if test="${not empty sessionScope.account.images}">
											<p>
												<strong>Profile Image:</strong>
											</p>
											<c:if test="${not empty sessionScope.account.images}">
												<img src="${sessionScope.image}"
													alt="Profile Image" class="profile-img" weight = 80 height = 80>
											</c:if>
										</c:if>
									
										<!-- Input để upload hình ảnh -->
										<p>
											<strong>Upload New Profile Image:</strong> <input type="file"
												name="profileImage" size="100" accept="image/*">
										</p>
										<!-- Nút gửi form -->
										<button type="submit" class="btn btn-primary">Cập
											nhật hình ảnh</button>
									</div>
								</c:when>
								<c:otherwise>
									<p>
										Bạn chưa đăng nhập. Vui lòng <a
											href="${pageContext.request.contextPath}/login">Đăng nhập</a>.
									</p>
								</c:otherwise>
							</c:choose>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- END CONTENT -->
</div>
