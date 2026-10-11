<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="header.jsp"/>

<div style="padding:100px 30px; background:#f5f6fa; min-height:100vh;">

    <!-- MAIN CARD -->
    <div style="width:90%; margin:auto; background:white; padding:30px; border-radius:12px; box-shadow:0 4px 12px rgba(0,0,0,0.08);">

        <!-- TITLE -->
        <h2 style="color:#2d2d2d; margin-bottom:5px;">Expense Summary</h2>

        <h3 style="color:#555;">
            ${group.groupName}
        </h3>

        <p style="color:#888;">
            ${group.startDate} → ${group.endDate}
        </p>

        <hr style="margin:20px 0; border:0.5px solid #eee;"/>

        <!-- SUMMARY CARDS -->
        <div style="display:flex; gap:20px; flex-wrap:wrap;">

            <!-- TOTAL COLLECTED -->
            <div style="flex:1; min-width:200px; background:#f1f2f6; padding:15px; border-radius:8px;">
                <p style="color:#777;">Total Collected</p>
                <h3 style="margin:0;">₹ ${totalInitial}</h3>
            </div>

            <!-- TOTAL SPENT -->
            <div style="flex:1; min-width:200px; background:#f1f2f6; padding:15px; border-radius:8px;">
                <p style="color:#777;">Total Expenses</p>
                <h3 style="margin:0;">₹ ${totalSpent}</h3>
            </div>

            <!-- NET BALANCE (FIXED LOGIC UI) -->
            <div style="flex:1; min-width:200px; background:#f1f2f6; padding:15px; border-radius:8px;">
                <p style="color:#777;">Net Balance</p>

                <h3 style="margin:0;">
                    <c:choose>

                        <c:when test="${remainingAmount > 0}">
                            <span style="color:green;">
                                ₹ ${remainingAmount} (Surplus)
                            </span>
                        </c:when>

                        <c:when test="${remainingAmount < 0}">
                            <span style="color:red;">
                                ₹ ${-remainingAmount} (Deficit)
                            </span>
                        </c:when>

                        <c:otherwise>
                            <span style="color:#555;">
                                ₹ 0 (Settled)
                            </span>
                        </c:otherwise>

                    </c:choose>
                </h3>
            </div>

            <!-- PER HEAD -->
            <div style="flex:1; min-width:200px; background:#f1f2f6; padding:15px; border-radius:8px;">
                <p style="color:#777;">Per Head</p>
                <h3 style="margin:0;">₹ ${perHead}</h3>
            </div>

        </div>

        <hr style="margin:25px 0; border:0.5px solid #eee;"/>

        <!-- TABLE -->
        <table style="width:100%; border-collapse:collapse;">

            <tr style="background:#f1f2f6;">
                <th style="padding:12px; border:1px solid #ddd;">User</th>
                <th style="padding:12px; border:1px solid #ddd;">Initial</th>
                <th style="padding:12px; border:1px solid #ddd;">Expense Paid</th>
                <th style="padding:12px; border:1px solid #ddd;">Total Paid</th>
                <th style="padding:12px; border:1px solid #ddd;">Per Head</th>
                <th style="padding:12px; border:1px solid #ddd;">Balance</th>
            </tr>

            <c:forEach var="s" items="${summaryList}">
                <tr>

                    <td style="padding:10px; border:1px solid #ddd;">${s.userName}</td>
                    <td style="padding:10px; border:1px solid #ddd;">₹ ${s.initialAmount}</td>
                    <td style="padding:10px; border:1px solid #ddd;">₹ ${s.extraPaid}</td>
                    <td style="padding:10px; border:1px solid #ddd;">₹ ${s.totalPaid}</td>
                    <td style="padding:10px; border:1px solid #ddd;">₹ ${s.perHead}</td>

                    <td style="padding:10px; border:1px solid #ddd; font-weight:bold;">

                        <c:choose>

                            <c:when test="${s.balance > 0}">
                                <span style="color:green;">
                                    Gets ₹ ${s.balance}
                                </span>
                            </c:when>

                            <c:when test="${s.balance < 0}">
                                <span style="color:red;">
                                    Pays ₹ ${-s.balance}
                                </span>
                            </c:when>

                            <c:otherwise>
                                <span style="color:#555;">
                                    Settled
                                </span>
                            </c:otherwise>

                        </c:choose>

                    </td>

                </tr>
            </c:forEach>

        </table>

        <br/>

        <!-- BACK BUTTON -->
        <a href="viewGroups"
           style="display:inline-block; padding:10px 15px; background:#ff6b00; color:white; text-decoration:none; border-radius:6px;">
            ← Back to Groups
        </a>

    </div>

</div>