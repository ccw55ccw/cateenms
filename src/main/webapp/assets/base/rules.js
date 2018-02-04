/**
 * Created by Administrator on 2017/12/20.
 */

var editor;

$(function(){

    var E = window.wangEditor;
    editor = new E('#editor1');
    editor.customConfig.uploadImgShowBase64 = true   // 使用 base64 保存图片
    editor.create();

});

function doUpdate() {
    var disabled = $('#update-btn').attr('disabled');
    $('#update-btn').attr('disabled', 'disabled');
    var html = editor.txt.html();
    var data = {
        rules:html
    };
    if (!disabled){
        $.post('/cms/api/rules_update', {
            dataJson:JSON.stringify(data)
        }, function (res) {
            if (res.isSuccess){
                window.location.href = '/cms/rules';
            }
        });
    }
}
