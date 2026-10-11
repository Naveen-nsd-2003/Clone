<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"/>

<div style="padding:100px 30px; background:#f5f6fa; min-height:100vh;">

    <div style="width:90%; margin:auto; background:white; padding:25px; border-radius:10px; box-shadow:0 3px 10px rgba(0,0,0,0.08);">

        <h2 style="color:#2d2d2d;">Expense List</h2>

        <table style="width:100%; border-collapse:collapse; margin-top:20px;">

            <tr style="background:#f1f2f6;">
                <th style="padding:10px; border:1px solid #ddd;">ID</th>
                <th style="padding:10px; border:1px solid #ddd;">Group</th>
                <th style="padding:10px; border:1px solid #ddd;">Date</th>
                <th style="padding:10px; border:1px solid #ddd;">Description</th>
                <th style="padding:10px; border:1px solid #ddd;">Paid By</th>
                <th style="padding:10px; border:1px solid #ddd;">Amount</th>
                <th style="padding:10px; border:1px solid #ddd;">Edit</th>
                <th style="padding:10px; border:1px solid #ddd;">Delete</th>
            </tr>

            <c:forEach var="e" items="${expenseList}">
                <tr>

                    <td style="padding:10px; border:1px solid #ddd;">${e.expId}</td>
                    <td style="padding:10px; border:1px solid #ddd;">${e.groupId}</td>
                    <td style="padding:10px; border:1px solid #ddd;">${e.expenseDate}</td>
                    <td style="padding:10px; border:1px solid #ddd;">${e.expenseDescription}</td>
                    <td style="padding:10px; border:1px solid #ddd;">${e.paidBy}</td>
                    <td style="padding:10px; border:1px solid #ddd;">${e.amount}</td>

                    <td style="text-align:center; border:1px solid #ddd;">
                        <a href="updateExpensePage?expId=${e.expId}"
                           style="padding:6px 10px; background:#e4e6eb; text-decoration:none; color:#2d2d2d; border-radius:5px;">
                            Edit
                        </a>
                    </td>

                    <td style="text-align:center; border:1px solid #ddd;">
                        <a href="deleteExpense?expId=${e.expId}"
                           style="padding:6px 10px; background:#ff6b00; text-decoration:none; color:white; border-radius:5px;">
                            Delete
                        </a>
                    </td>

                </tr>
            </c:forEach>

        </table>

        <br/>

        <a href="expenseForm"
           style="padding:10px 15px; background:#ff6b00; color:white; text-decoration:none; border-radius:5px;">
            + Add Expense
        </a>

    </div>

</div>