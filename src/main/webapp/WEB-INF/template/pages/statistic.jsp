<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="row mt-3">
    <div class="col">
        <h2 class="title h2 text-center">Statistic by
            <c:if test="${statisticType=='by-tests'}">
                tests
            </c:if>
            <c:if test="${statisticType=='by-questions'}">
                questions
            </c:if>
        </h2>
    </div>
</div>
<c:if test="${!empty listStatistic}">
    <div class="row">
        <div class="col">
            <table table id="statisticDataTable" class="table table-hover table-sm">
                <thead class="special-color-dark white-text">
                <tr>
                    <th>
                        <c:if test="${statisticType=='by-tests'}">
                            Tests name
                        </c:if>
                        <c:if test="${statisticType=='by-questions'}">
                            Questions description
                        </c:if>
                    </th>
                    <th class="text-center">Passed amount</th>
                    <th class="text-center">Percentage of correct answers</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listStatistic}" var="statistic">
                    <tr>
                        <td>
                            <c:if test="${statisticType=='by-tests'}">
                                ${statistic.test.name}
                            </c:if>
                            <c:if test="${statisticType=='by-questions'}">
                                ${statistic.question.description}
                            </c:if>
                        </td>
                        <td class="w-25 text-center">${statistic.amountPass}</td>
                        <td class="w-25 text-center">${statistic.correct/statistic.total*100} %</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</c:if>
<c:if test="${empty listStatistic}">
    <div class="row mt-3">
        <div class="col">
            <h4 class="title h4-responsive text-center text-success">Sorry! Statistic list is empty</h4>
        </div>
    </div>
</c:if>
<div class="mt-3 text-right pr-2">
    <a href="<%=application.getContextPath()%>/" class="text-success">Back to main page</a>
</div>
