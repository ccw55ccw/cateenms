/**
 * Created by Administrator on 2018/1/27.
 */

$(function(){

    $('#subbtn').click(function () {
        var data = $('#tform').serializeObject();
        $.post('/cms/api/opinion_add', {
            dataJson:data
        }, function (res) {
            if (res.isSuccess){
                layer.msg('建议提交成功');
                setTimeout(function () {
                    window.location.reload();
                }, 1000);

            }
        });
    });

});

