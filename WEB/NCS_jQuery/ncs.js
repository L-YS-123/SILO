// 회원의 정보 : 아이디, 비밀번호, 이름
// Member -> 생성자 함수를 정의
function Member(id, pw, name) {
    this.userId = id;
    this.pw = pw;
    this.userName = name;
}
// 객체가 가지는 메소드는 공통으로 사용 -> prototype
Member.prototype.makeHtml = function () {
    return '[id:' + this.userId + ' , pw: ' + this.pw + ' , name: ' + this.userName + ' ]'
};
// 회원의 정보를 저장하는 배열
var members = []; // new Array()

$(document).ready(function () {

    // 사용자가 입력한 값 
    var userid = $('#userID');
    var pw = $('#pw');
    var repw = $('#repw');
    var userName = $('#userName');

    // regForm 캐스팅 , 캐스팅: 태그를 문서객체로 만드는 것
    var regForm = $('#regForm');

    regForm.onsubmit = function () {

        // 배열에 사용자 정보를 추가
        members.push(new Member(userid.val(), pw.val(), userName.val()));

        // 저장
        localStorage.setItem('members', JSON.stringify(members));

        alert('등록되었습니다.');

        console.log(userid.val());
        console.log(pw.val());
        console.log(repw.val());
        console.log(userName.val());

        console.log('회원 리스트', members);

        // form 초기화
        this.reset();

        // 테이블 세팅
        // setList();

        // return false;

    }

});

// 배열에 있는 요소를 -> table tr 행을 만들어서 출력
function setList() {


    // table 의 tbody 캐스팅
    var list = document.querySelector('#list');

    var tbody = '<tr>';
    tbody += '  <th>순번(index)</th>';
    tbody += '  <th>아이디</th>';
    tbody += '  <th>비밀번호</th>';
    tbody += '  <th>이름</th>';
    tbody += '  <th>관리</th>';
    tbody += '</tr>';

    if (members.length < 1) {

        tbody += '<tr>';
        tbody += '<td colspan="5">데이터가 존재하지않습니다.</td>';
        tbody += '</tr>';


    } else {

        for (var i = 0; i < members.length; i++) {
            tbody += '<tr>';
            tbody += '  <td>' + i + '</td>';
            tbody += '  <td>' + members[i].userId + '</td>';
            tbody += '  <td>' + members[i].pw + '</td>';
            tbody += '  <td>' + members[i].userName + '</td>';
            tbody += '  <td> <a href="javascript:editMember(' + i + ')">수정</a> | <a href="javascript:deleteMember(' + i + ')">삭제</a></td>';
            tbody += '</tr>';
        }
    }


    list.innerHTML = tbody;
    // $('#list').html('tbody');



}