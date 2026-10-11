<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"/>

<div style="padding:100px 30px; background:#f5f6fa; min-height:100vh;">

    <div style="width:500px; margin:auto; background:white; padding:25px; border-radius:10px; box-shadow:0 3px 10px rgba(0,0,0,0.08);">

        <h2 style="text-align:center; color:#2d2d2d;">Update Expense</h2>

        <form action="updateExpense">

            <input type="hidden" name="expId" value="${expense.expId}"/>

            <label>Select Group</label>
            <select name="groupId"
                    style="width:100%; padding:8px; margin:8px 0; border:1px solid #ddd; border-radius:5px;">
                <c:forEach var="g" items="${groups}">
                    <option value="${g.groupId}"
                        <c:if test="${g.groupId == expense.groupId}">selected</c:if>>
                        ${g.groupName}
                    </option>
                </c:forEach>
            </select>

            <label>Expense Date</label>
            <input type="date" name="expenseDate" value="${expense.expenseDate}"
                   style="width:100%; padding:8px; margin:8px 0; border:1px solid #ddd; border-radius:5px;"/>

            <label>Description</label>
            <input type="text" name="expenseDescription" value="${expense.expenseDescription}"
                   style="width:100%; padding:8px; margin:8px 0; border:1px solid #ddd; border-radius:5px;"/>

            <label>Paid By</label>
            <select name="paidBy"
                    style="width:100%; padding:8px; margin:8px 0; border:1px solid #ddd; border-radius:5px;">
                <c:forEach var="u" items="${users}">
                    <option value="${u.userId}"
                        <c:if test="${u.userId == expense.paidBy}">selected</c:if>>
                        ${u.userName}
                    </option>
                </c:forEach>
            </select>

            <label>Amount</label>
            <input type="text" name="amount" value="${expense.amount}"
                   style="width:100%; padding:8px; margin:8px 0; border:1px solid #ddd; border-radius:5px;"/>

            <br/>

            <input type="submit" value="Update"
                   style="width:100%; padding:10px; background:#ff6b00; color:white; border:none; border-radius:5px;"/>

        </form>

        <br/>

        <a href="viewExpenses"
           style="display:block; text-align:center; padding:10px; background:#e4e6eb; color:#2d2d2d; text-decoration:none; border-radius:5px;">
            Back to Expenses
        </a>

    </div>

</div>