/**
 * 登录前的校验
 * @returns
 */

function confirm() {
    var username = $("#username").val();
    var password = $("#password").val();
    if (username == "" || username == null) {
        alert("用户名不能为空");
        return false;
    } else if (password == "" || password == null) {
        alert("密码不能为空");
        return false;
    } 
    return true;
}