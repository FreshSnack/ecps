$(function () {
    /*给菜单项绑定点击事件*/
    $(".nav a").on('click', function (event) {
        var name = event.target.name;
        $('.nav .one_link').removeClass("one_link");
        $('.nav a[name=' + name + ']').addClass("one_link");
    });

    /*alert([[${pv_count}]])*/

    // 设置content最小高度;
    $("body>.content").css("minHeight", getContentMinHeight());
    $(window).resize(function () {
        $("body>.content").css("minHeight", getContentMinHeight());
    });

    $("body>.footer").show();

    /**
     * 获取内容区最小高度
     * @returns {number}
     */
    function getContentMinHeight() {
        return $(window).height() - $(".header").outerHeight() - $(".menu").outerHeight() - $(".footer").outerHeight() - 70;
    }

    layui.use('layer', function () { window.layer = layui.layer; });
});


/**
 * 增加访问量
 * @param code
 */
function addVisitCount(code) {
    // 每刷新一次增加一次访问量
    $.post({
        url: '/addVisitCount',
        data: {code: code},
        success: function (ar) {
            if (ar.code != '0') {
                alert(ar.msg);
            }
        }
    });
}

/**
 * 访客留言
 */
function message() {
    layer.open({
        type: 2,
        title: '访客留言',
        /*skin: 'layui-layer-rim', //加上边框*/
        area: ['480px', '282px'], //宽高
        content: '/message'
    });
}

/**
 * 关闭访客留言
 */
function closeMessage() {
    layer.closeAll('iframe');
    layer.msg('留言成功');
    if(refreshMsg) {
        refreshMsg();
    }
}

/**
 * 下载文件
 * @param id
 */
function download(id) {
    window.location.href = "/download?id=" + id;
}

/**
 * 预览文件
 */
function preview(id, filename) {
    parent.layer.open({
        title: filename,
        type: 1,
        skin: 'layui-layer-rim', //加上边框
        area: [$(parent.document).width()*0.8 + 'px', ($(parent.document).height() - 100) + 'px'], //宽高
        content: '<iframe src="pdfjs/web/viewer.html?file=/download?id%3D' + id + '" width=100% height=100% frameborder="0"></iframe>'
    });
}