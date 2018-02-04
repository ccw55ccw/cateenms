/**
 * Created by Administrator on 2017/12/20.
 */
$.fn.serializeObject = function() {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [ o[this.name] ];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return JSON.stringify(o);
};


/**
 *
 * 小朋友有一个表单，他想以Json的方式获取到表单的内容。小朋友尝试了以下方式。

 通过$("#form").serialize()可以获取到序列化的表单值字符串。

 a=1&b=2&c=3&d=4&e=5
 通过$("#form").serializeArray()输出以数组形式序列化表单值。

 [
 {name: 'firstname', value: 'Hello'},
 {name: 'lastname', value: 'World'},
 {name: 'alias'}, // 值为空
 ]
 统统不满足小朋友想得到Json的愿望。堆栈溢出后，找到了一个这样的方法

 $.fn.serializeObject = function()
 {
     var o = {};
     var a = this.serializeArray();
     $.each(a, function() {
         if (o[this.name] !== undefined) {
             if (!o[this.name].push) {
                 o[this.name] = [o[this.name]];
             }
             o[this.name].push(this.value || '');
         } else {
             o[this.name] = this.value || '';
         }
     });
     return o;
 };
 然后通过JSON.stringify($("#form").serializeObject()); 就可以得到Json内容噜。
 *
 *
 */

