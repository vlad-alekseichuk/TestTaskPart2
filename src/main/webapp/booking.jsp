<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create an account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/matrix.css" rel="stylesheet">

</head>
<body>
<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>


        <h2>
            Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a>
        </h2>

        <c:if test="${isAdmin}">
            <br/>
            <form id="redistributeForm" method="get" action="/redistribute">
                <button type="submit">Redistribute all occupied places</button>
            </form>
        </c:if>

        <br/>
        <div class="content">
            <div class="row">
                <div class="matrix">
                    <c:forEach items="${rowList}" var="row">
                        <div class="matrix__row">
                            <c:forEach items="${row.seats}" var="seat">
                                <c:if test="${seat.available && !seat.forBooking}">
                                    <div class="matrix__item"></div>
                                </c:if>
                                <c:if test="${seat.available && seat.forBooking}">
                                    <div class="matrix__item matrix__item_selected"></div>
                                </c:if>
                                <c:if test="${!seat.available}">
                                    <div class="matrix__item matrix__item_booked"></div>
                                </c:if>

                            </c:forEach>
                        </div>
                    </c:forEach>

                </div>
                <div class="form">
                    <form:form commandName="searchParams" method="post" action="/search" id="searchForm">
                        <div class="form__input">
                            <label for="row">Row:</label>
                            <form:input id="row" path="rowNumber" type="number"/>
                        </div>
                        <div class="form__input">
                            <label for="count">Number of seats:</label>
                            <form:input id="count" path="numberOfSeats" type="number"/>
                        </div>

                        <div class="form__input">
                            <button type="submit">Search places</button>
                        </div>

                    </form:form>
                </div>
            </div>

            <div class="row">
                <div class="form">
                    <h3>Choose your seats</h3>
                    <c:if test="${!empty availableSeats}">
                        <form:form commandName="bookParams" method="post" action="/book" id="bookForm">
                            <c:forEach items="${availableSeats}" var="seats">
                                <div class="form__input">
                                    <label>
                                        Row ${seats[0].row.number} places
                                        <c:forEach items="${seats}" var="seat">
                                            ${seat.number}
                                        </c:forEach>
                                    </label>
                                    <form:radiobutton path="seatsToBook" value="${seats}"/>
                                </div>
                            </c:forEach>

                            <div class="form__input">
                                <button type="submit">Make a booking</button>
                            </div>
                        </form:form>
                    </c:if>
                </div>
            </div>
        </div>
    </c:if>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
