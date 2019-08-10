
$(function () {
    layui.use(["layer", "element"], function () {
        // 开放layer属性
        window.layer = layui.layer;
    });

    $(".layui-side a").on('click', function (event) {
        var name = event.target.name;
        if(name) {
            $(".frame iframe").attr("src", "/admin/" + name);
        }
    });
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