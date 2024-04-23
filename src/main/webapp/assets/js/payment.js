// 구매자 정보
const user_email = 'hong@gmail.com';
const username = 'hongsoon';

// 결제창 함수 넣어주기
const buyButton = document.getElementById('payment')
buyButton.setAttribute('onclick', `kakaoPay('${user_email}', '${username}')`)

var IMP = window.IMP;

var today = new Date();
var hours = today.getHours(); // 시
var minutes = today.getMinutes();  // 분
var seconds = today.getSeconds();  // 초
var milliseconds = today.getMilliseconds();
var makeMerchantUid = `${hours}` + `${minutes}` + `${seconds}` + `${milliseconds}`;

function kakaoPay(useremail, username) {
    if (confirm("구매 하시겠습니까?")) { // 구매 클릭시 한번 더 확인하기
        if (localStorage.getItem("access")) { // 회원만 결제 가능
            const emoticonName = document.getElementById('title').innerText;

            IMP.init("imp58685680"); // 가맹점 식별코드
            IMP.request_pay({
                pg: 'kakaopay.TC0ONETIME', // PG사 코드표에서 선택
                pay_method: 'card', // 결제 방식
                merchant_uid: "IMP" + makeMerchantUid, // 결제 고유 번호
                name: '상품명', // 제품명
                amount: 10, // 가격
                //구매자 정보 ↓
                buyer_email: `${useremail}`,
                buyer_name: `${username}`
                // buyer_tel : '010-1234-5678',
               
                // buyer_addr : '서울특별시 강남구 삼성동',
                
                // buyer_postcode : '123-456'
           
           
            }, function (rsp) { // callback
    // 비동기 작업을 Promise로 래핑
    return new Promise(function(resolve, reject) {
        if (rsp.success) { //결제 성공시
            console.log(rsp);
            
            //결제 성공시 프로젝트 DB저장 요청

            if (response.status == 200) { // DB저장 성공시
                alert('결제 완료!');
                window.location.reload();
                resolve(); // 성공했으므로 resolve 호출
            } else { // 결제완료 후 DB저장 실패시
                alert(`error:[${response.status}]\n결제요청이 승인된 경우 관리자에게 문의바랍니다.`);
                // DB저장 실패시 status에 따라 추가적인 작업 가능성
                reject(); // 실패했으므로 reject 호출
            }
        } else if (rsp.success == false) { // 결제 실패시
            alert(rsp.error_msg);
            reject(); // 실패했으므로 reject 호출
        }
    });
});
}
}
}