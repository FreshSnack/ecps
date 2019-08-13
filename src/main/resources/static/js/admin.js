
$(function () {
    layui.use(["layer", "element", "upload"], function () {
        // 开放layer功能
        window.layer = layui.layer;
        // 开放upload功能
        window.upload = layui.upload;
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

/**
 * 刷新frame内容
 */
function refreshFrame() {
    $("#frame").attr("src", $("#frame").attr("src"));
}