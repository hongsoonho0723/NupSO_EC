

if (typeof window.IMP === "undefined") {
  console.error("window.IMP 객체가 정의되지 않았습니다.");
} else {
	console.log("ok")
  const IMP = window.IMP;
  // IMP 객체가 정의되었으므로 init() 메서드를 호출할 수 있습니다.
  IMP.init("imp58685680");

  
const button = document.querySelector("#btn");

const onClickPay = async () =>{
	
	IMP.request_pay({
    pg : 'kakaopay',
    pay_method : 'card',
    merchant_uid: "order_no_0007", //상점에서 생성한 고유 주문번호 //성공시 주문번호가 어딘가에저장되어 변경해줘야함
    name : '주문명:결제테스트',
    amount : 1200000,
 }, function(rsp) {
    if ( !rsp.success ) {
    	//결제 시작 페이지로 리디렉션되기 전에 오류가 난 경우
        var msg = '오류로 인하여 결제가 시작되지 못하였습니다.';
        msg += '에러내용 : ' + rsp.error_msg;

        alert(msg);
    } else {
		alert("결제 성공")
		
		//메서드 주문테이블에 insert필요 정보
		
		
  window.location.href = 'http://localhost:8000/NupSO_EC/cart.jsp';
      }
});
	
	
};

button.addEventListener("click", onClickPay);


}









