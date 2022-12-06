// function getUserName() {
//     // ${@registerMethod.getRegisterCode(\'getUserName()\')}
//     request.setQuery();
//     return
//     // var a="register(userEmail="+document.getElementById("userEmail").value+")";
//     // let b=window.location.href.toString();
//     // b=b.replace("register",a);
//     // window.location.replace(b);
// };

window.onload =function(){

    var code = document.getElementById("getcode");
    code.onclick=getcode;
    function getcode(){
        var userEmail = document.getElementById("userEmail").value;
        $.ajax({
            type: "POST",
            url:"http://localhost:8088/getcode",
            data:{
                "userEmail":userEmail,
            },
            SUCCESS:function(res){
                document.write(res);
                document.close();
            }
        })
    }
    var btn_sub = document.getElementById("submit");
    btn_sub.onclick=submit;

    function submit(){
        var userName = document.getElementById("userName").value;
        var userEmail = document.getElementById("userEmail").value;
        var userPassword = document.getElementById("userPassword").value;
        var userPasswordAgain = document.getElementById("userPasswordAgain").value;
        var code = document.getElementById("code").value;
        $.ajax({
            type: "POST",
            url:"http://localhost:8088/registerConfirm",
            data:{
                "user":{
                    "userName":userName,
                    "userEmail":userEmail,
                    "userPassword":userPassword,
                    "userPasswordAgain":userPasswordAgain,
                    "code":code,
                }
            },
            SUCCESS:function(res){
                document.write(res);
                document.close();
                var warn = [[${warn}]];
                var error = [[${error}]];
                var fault = [[${fault}]];
                if(warn.length===0 && error.length===0 && fault.length===0){
                    alert("register success!!!");
                    window.location.replace("http://localhost:8088/login");
                }else{
                    var message=[warn,error,fault];
                    var info ="";
                    message.forEach((item)=>{
                        if(item.length!==0){
                            info=info+item+"\n";
                        }
                    })
                    alert(info);
                }
            }
        })
    }

}

