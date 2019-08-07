
$(function () {
    layui.use("element");
});


/**
 * 登出
 */
function logout() {
    $.post({
        url: '/admin/logout',
        success: function (ar) {
            if (ar.code != '0') {
                alert(ar.msg);
            } else {
                window.location.href = "/";
            }
        }
    });
}

/**
 * 修改密码
 */
function modifyPassword() {
    alert("sss");
}