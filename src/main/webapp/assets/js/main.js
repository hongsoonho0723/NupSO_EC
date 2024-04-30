


if (typeof window.IMP === "undefined") {
  console.error("window.IMP 객체가 정의되지 않았습니다.");
} else {
	console.log("ok")
  const IMP = window.IMP;
  // IMP 객체가 정의되었으므로 init() 메서드를 호출할 수 있습니다.
  IMP.init("imp58685680");

  
const button = document.querySelector("#btn");

const onClickPay = async () => {
    const addr1 = document.getElementById("addr1").value;
    const addr2 = document.getElementById("addr2").value;
    const name = document.getElementById("name").value;
    const phone = document.getElementById("phone").value;
    const date = document.getElementById("datepicker").value;
    
    // 주소, 이름, 전화번호 필드가 비어 있는지 확인
    if (!addr1 || !addr2 || !name || !phone || !date) {
        alert("주소, 이름, 전화번호를 모두 입력해주세요.");
        return; // 필드가 하나라도 비어 있으면 결제를 진행하지 않음
    }    

    IMP.request_pay({
        pg: 'kakaopay',
        pay_method: 'card',
        name: '주문명:결제테스트',
        amount: $("#totalInput").val(),
    }, function(rsp) {
        if (!rsp.success) {
            //결제 시작 페이지로 리디렉션되기 전에 오류가 난 경우
            var msg = '오류로 인하여 결제가 시작되지 못하였습니다.';
            msg += '에러내용 : ' + rsp.error_msg;
            alert(msg);
        } else {
            alert("결제 성공");
            
            //메서드 주문테이블에 insert필요 정보
            document.getElementById("orderForm").submit();
        }
    });
};

button.addEventListener("click", onClickPay);

}









