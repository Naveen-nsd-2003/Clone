<jsp:include page="header.jsp"/>

<div style="padding:30px; background:#f5f6fa; min-height:100vh;">

    <div style="width:400px; margin:auto; background:white; padding:25px; border-radius:10px; box-shadow:0 3px 10px rgba(0,0,0,0.08);">

        <h2 style="text-align:center; color:#2d2d2d;">Add User</h2>

        <form action="saveUser">

            <label>Name</label><br/>
            <input type="text" name="userName" required
                   style="width:100%; padding:8px; margin:8px 0; border:1px solid #ddd; border-radius:5px;"/>

            <label>Email</label><br/>
            <input type="text" name="email" required
                   style="width:100%; padding:8px; margin:8px 0; border:1px solid #ddd; border-radius:5px;"/>

            <br/>

            <input type="submit" value="Add User"
                   style="width:100%; padding:10px; background:#ff6b00; color:white; border:none; border-radius:5px;"/>

        </form>

    </div>

</div>