window.onload = fillDate("data1.json");

function searchData() {
    var lis = document.getElementById("navigation_bar").getElementsByTagName("li");
    for (var i = 0; i < lis.length; i++) {
        lis[i].onclick = function() {
            for (var i = 0; i < lis.length; i++) {
                lis[i].className = "";
                lis[i].index = i;

            }
            this.className = "select_selected";

            fillDate("data" + (this.index + 1) + ".json");
        }
    }
}

function fillDate(url) {
    ajax('get', url, true, function(resp) {
        var productJsonData = JSON.parse(resp);

        for (var obj of productJsonData) {
            // 商品图片
            document.getElementById("pro_img" + obj.id).src = obj.img;

            // new&sale
            if (obj.type == "0") {
                document.getElementById("pro_sale" + obj.id).hidden = true;
                document.getElementById("pro_new" + obj.id).hidden = false;
            } else {
                document.getElementById("pro_new" + obj.id).hidden = true;
                document.getElementById("pro_sale" + obj.id).hidden = false;
            }

            // 商品名
            document.getElementById("pro_name" + obj.id).innerText = obj.name;

            // 星标
            var imgLis = document.getElementById("pro_star" + obj.id).getElementsByTagName("img");
            var length = imgLis.length;

            for (var i = 0; i < length; i++) {
                document.getElementById("pro_star" + obj.id).removeChild(imgLis[0]);
            }

            for (var i = 0; i < 5; i++) {
                var star_img = document.createElement("img");
                if (i < obj.star) {
                    star_img.src = "./img/electronic/star1.jpg";
                    document.getElementById("pro_star" + obj.id).appendChild(star_img);
                } else {
                    star_img.src = "./img/electronic/star2.jpg";
                    document.getElementById("pro_star" + obj.id).appendChild(star_img);
                }
            }

            // 价格
            document.getElementById("pro_price_new" + obj.id).innerText = obj.newPrice;
            document.getElementById("pro_price_old" + obj.id).innerText = obj.oldPrice;

        }

    })
}

function ajax(method, url, async, callback, postData) {
    //1.创建对象
    var xhr = new XMLHttpRequest();

    //2. 监听事件
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                callback(xhr.responseText);
            } else {
                alert('error=' + xhr.status);
            }
        }
    }

    //3. 打开请求（配置请求）
    xhr.open(method, url, async);

    //发送请求
    if (postData === undefined) {
        xhr.send(null);
    } else {
        xhr.send(postData);
    }

}