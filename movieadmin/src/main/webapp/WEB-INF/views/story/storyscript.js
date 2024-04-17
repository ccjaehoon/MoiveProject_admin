// 댓글 삭제 함수
function deleteComment(storyCommentsNum) {
    // 여기에 댓글 삭제 로직을 구현하세요.
    // 예를 들어, 서버로 댓글 삭제 요청을 보내는 코드 등을 작성합니다.
    // 삭제 성공 시 댓글 목록 업데이트 또는 페이지 새로고침을 수행할 수 있습니다.
}

document.addEventListener('DOMContentLoaded', function() {
    // 삭제 버튼에 클릭 이벤트 리스너 추가
    document.querySelectorAll('.report').forEach(function(button) {
        button.addEventListener('click', function(event) {
            // 삭제할 댓글의 고유 번호와 게시글 번호 가져오기
            var storyCommentsNum = this.parentElement.previousElementSibling.querySelector('input[name="story_comments_num"]').value;
            var storyNum = this.parentElement.previousElementSibling.previousElementSibling.querySelector('input[name="story_num"]').value;

            // 삭제 요청 보내기
            fetch(`SComments_deleteOK.do?story_comments_num=${storyCommentsNum}&story_num=${storyNum}`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                },
            })
            .then(response => response.json())
            .then(data => {
                if (data.success) {
                    // 삭제 성공 시 댓글 목록 업데이트 또는 페이지 새로고침
                    location.reload();
                } else {
                    alert('삭제에 실패했습니다.');
                }
            })
            .catch(error => {
                console.error('Error:', error);
                alert('삭제에 실패했습니다.');
            });
        });
    });
});