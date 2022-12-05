function getUserName() {
    var a="getcode?userEmail="+document.getElementById("userEmail").value;
    let b=window.location.href.toString();
    b=b.replace("register",a);
    window.location.replace(b);
};