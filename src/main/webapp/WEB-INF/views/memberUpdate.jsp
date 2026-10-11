<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"/>

<div style="padding:100px 30px; background:#f5f6fa; min-height:100vh;">

    <div style="width:450px; margin:auto; background:white; padding:25px; border-radius:10px; box-shadow:0 3px 10px rgba(0,0,0,0.08);">

        <h2 style="text-align:center; color:#2d2d2d;">Update Member</h2>

        <form action="updateMember">

            <input type="hidden" name="gmId" value="${member.gmId}"/>

            <label>Select Group</label>
            <select name="groupId"
                    style="width:100%; padding:8px; margin:8px 0; border:1px solid #ddd; border-radius:5px;">
                <c:forEach var="g" items="${groups}">
                    <option value="${g.groupId}"
                        <c:if test="${g.groupId == member.groupId}">selected</c:if>>
                        ${g.groupName}
                    </option>
                </c:forEach>
            </select>

            <label>Select User</label>
            <select name="userId"
                    style="width:100%; padding:8px; margin:8px 0; border:1px solid #ddd; border-radius:5px;">
                <c:forEach var="u" items="${users}">
                    <option value="${u.userId}"
                        <c:if test="${u.userId == member.userId}">selected</c:if>>
                        ${u.userName}
                    </option>
                </c:forEach>
            </select>

            <label>Amount Collected</label>
            <input type="text" name="amountCollected" value="${member.amountCollected}"
                   style="width:100%; padding:8px; margin:8px 0; border:1px solid #ddd; border-radius:5px;"/>

            <br/>

            <input type="submit" value="Update Member"
                   style="width:100%; padding:10px; background:#ff6b00; color:white; border:none; border-radius:5px;"/>

        </form>

        <br/>

        <a href="viewMembers"
           style="display:block; text-align:center; padding:10px; background:#e4e6eb; color:#2d2d2d; text-decoration:none; border-radius:5px;">
            Back to Members
        </a>

    </div>

</div>