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