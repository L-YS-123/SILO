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


    var regExp1 = /^[a-zA-Z0-9]{4,12}$/; //아이디

    regForm.on('submit', function (userId) {


        if (!regExp1.test(userid.val())) {
            alert('적절하지 않은 아이디 입니다.');
            return false;
        } else {
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
            setList();

            return false;

        }



    })





});

// 배열에 있는 요소를 -> table tr 행을 만들어서 출력
function setList() {


    // table 의 tbody 캐스팅
    var list = $('#list');

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

    $('#list').html(tbody);



}


// 배열의 요소 삭제 함수
function deleteMember(index) {
    // alert(index+' 인덱스의 요소를 삭제합니다.');

    var chk = confirm('삭제하시겠습니까?');

    //배열의 index요소 삭제
    //splice(index, count) : index에서 시작해서 count만큼의 요소를 삭제하고 남은 요소를 반환(?)
    //splice(index,1)
    if (confirm('삭제하시겠습니까?')) {
        members.splice(index, 1);
        alert('삭제되었습니다.');
        //테이블 리스트를 갱신
        setList();
    }

}




// 배열의 요소 수정함수
function editMember(index) {

    // 수정 폼 영역이 노출되어야 한다.
    document.querySelector('#editFormArea').style.display = 'block';

    // alert(index + ' 인덱스의 요소를 수정합니다.');

    // 전달받은 index값으로 members 배열의 객체 하나를 얻을 수 있다
    console.log(index, members[index])

    // editForm의 태그들의 value값을 세팅해보자
    var editUserId = document.querySelector('#editId');
    var editPw = document.querySelector('#editPw');
    var editRePw = document.querySelector('#editRePw');
    var editName = document.querySelector('#editName');
    var editIndex = document.querySelector('#index');

    // 이전 데이터를 form에 세팅
    editUserId.value = members[index].userId;
    editPw.value = members[index].pw;
    editRePw.value = members[index].pw;
    editName.value = members[index].userName;
    editIndex.value = index;

    document.querySelector('#editForm').onsubmit = function () {

        // var member = new Member(editUserId.value, editPw.value, editName.value);
        // console.log(editIndex.value, member);


        // 비밀번호와 비밀번호 확인이 같은지 체크
        if (editPw.value != editRePw.value) {
            alert('비밀번호와 비밀번호확인이 일치하지 않습니다.');
            return false;
        }



        if (!confirm('수정하시겠습니까?')) {
            return false;
        }

        members[editIndex.value].pw = editPw.value;
        members[editIndex.value].userName = editName.value;

        //저장
        localStorage.setItem('members', JSON.stringify(members));

        alert('수정되었습니다!');

        // 테이블 세팅
        setList();

        editMemberClose();

        return false;
    }

}

//닫기
function editMemberClose() {
    document.querySelector('#editFormArea').style.display = 'none';
}







