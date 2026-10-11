<jsp:include page="header.jsp"/>

<div style="padding:100px 30px; background:#f5f6fa; min-height:100vh;">

    <div style="width:450px; margin:auto; background:white; padding:25px; border-radius:10px; box-shadow:0 3px 10px rgba(0,0,0,0.08);">

        <h2 style="text-align:center; color:#2d2d2d;">Update Group</h2>

        <form action="updateGroup">

            <input type="hidden" name="groupId" value="${group.groupId}"/>

            <label>Created By</label>
            <input type="text" name="createdBy" value="${group.createdBy}"
                   style="width:100%; padding:8px; margin:8px 0; border:1px solid #ddd; border-radius:5px;"/>

            <label>Group Name</label>
            <input type="text" name="groupName" value="${group.groupName}"
                   style="width:100%; padding:8px; margin:8px 0; border:1px solid #ddd; border-radius:5px;"/>

            <label>Start Date</label>
            <input type="date" name="startDate" value="${group.startDate}"
                   style="width:100%; padding:8px; margin:8px 0; border:1px solid #ddd; border-radius:5px;"/>

            <label>End Date</label>
            <input type="date" name="endDate" value="${group.endDate}"
                   style="width:100%; padding:8px; margin:8px 0; border:1px solid #ddd; border-radius:5px;"/>

            <label>Amount</label>
            <input type="text" name="initialAmount" value="${group.initialAmount}"
                   style="width:100%; padding:8px; margin:8px 0; border:1px solid #ddd; border-radius:5px;"/>

            <br/>

            <input type="submit" value="Update"
                   style="width:100%; padding:10px; background:#ff6b00; color:white; border:none; border-radius:5px;"/>

        </form>

    </div>

</div>