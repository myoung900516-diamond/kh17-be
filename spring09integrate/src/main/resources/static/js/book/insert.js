$(function(){
    var state = {
        bookTitleValid : false,
        bookAuthorValid : true,
        bookPublicationDateValid : true,
        bookPriceValid : false,
        bookPublisherValid : true,
        bookPageCountValid : false, 
        bookGenreValid : false, 
        ok : function(){
            return Object.values(this)
                .filter(v => typeof v === "boolean")
                .every(v => v === true);  
        }
    };
    $("[name=bookTitle]").on("blur", function(){
        var value = $(this).val();
        var valid = value.length > 0 && value.length <= 300;
        $(this).removeClass("success fail").addClass(valid? "success": "fail");
        state.bookTitleValid = valid;
    });
    $("[name=bookAuthor]").on("blur", function(){
        var regex = /^[^!@#$]+$/;
        var value = $(this).val();
        var valid = value.length == 0 || regex.test(value);
        $(this).removeClass("success fail").addClass(valid? "success": "fail");
        state.bookAuthorValid = valid;
    });
    $("[name=bookPublicationDate]").on("blur", function(){
        var regex = /^([0-9]{4})-(((02)-(0[1-9]|1[0-9]|2[0-9]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30))|((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01])))$/;
        var valid = regex.test($(this).val());
        $(this).removeClass("success fail").addClass(valid? "success": "fail");
        
        state.bookPublicationDateValid = valid;
    });         
    $("[name=bookPrice]").on("blur", function(){
        var price = parseInt($(this).val());
        var valid = price >= 0 && price <= 1000000000;
        $(this).removeClass("success fail").addClass(valid? "success": "fail");
        
        state.bookPriceValid = valid;
    });
    $("[name=bookPublisher]").on("blur", function(){
        $(this).addClass("success");
        
        
    });         
    $("[name=bookPageCount]").on("blur", function(){
        var pages = parseInt($(this).val());
        var valid = pages > 0;
        $(this).removeClass("success fail").addClass(valid? "success": "fail");
        
        state.bookPageCountValid = valid;
    });
    $("[name=bookGenre]").on("input", function(){
        var regex = /^(판타지|교양|소설|역사|과학|추리소설|자기계발|수험서)$/;
        var valid = regex.test($(this).val());
        $(this).removeClass("success fail").addClass(valid? "success": "fail");

        state.bookGenreValid = valid;
    });
    $("[inputmode=numeric]").on("input", function(){
        var regex = /[^0-9]+/g;
        var replacement = $(this).val().replace(regex, "");
        $(this).val(replacement);
    });
    $(".form-check").on("submit", function(){
        $(this).find("select[name]").trigger("input");
        $(this).find("input[name], textarea[name]").trigger("blur");

        return state.ok();
    });
	$("[name=attach]").on("input", function(){
        var originSrc = $(".preview").attr("src");//현재 .preview의 src를 가져와서
        if(originSrc.startsWith("blob:")){//생성된 주소가 존재한다면
            URL.revokeObjectURL(originSrc);//생선된 주소를 회수하세요.
            
        }

        //this == 파일 입력창(files라는 내부 속성이 존재)
        if(this.files.length > 0){//파일을 선택한 경우(미리보기 생성)
            var address = URL.createObjectURL(this.files[0]);//파일을 주고 주소 생성을 요청
            $(".preview").attr("src", address);

        }
        else{//파일 선택을 취소한 경우(미리보기를 삭제할 수는없고, 더미이미지를  )
            $(".preview").attr("src", "https://dummyimage.com/200x200?text=NO");
        }
    });
});