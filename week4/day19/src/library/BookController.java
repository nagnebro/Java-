package library;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class BookController {
    private List<Book> list = new ArrayList<>(); // 이렇게 사용하는 것도 가능하긴함 ArrayList는 List인터페이스를 구현하기 떄문에

    BookController() {
        list.add(new Book("자바의 정석", "남궁 성", "기타", 20000));
        list.add(new Book("쉽게 배우는 알고리즘", "문병로", "기타", 15000));
        list.add(new Book("대화의 기술", "강보람", "인문", 17500));
        list.add(new Book("암 정복기", "박신우", "의료", 21000));
    }

    void insertBook(Book bk) { // 도서 추가
        if(bk.equals())
        list.add(bk); //중복 예외처리 안하나 -> 나중에 내가 한번 해봐야겠다. 우선은 그냥 구현하자.
    }

    ArrayList selectList() {  // 도서 전체조회
        return (ArrayList) list;
    }

    ArrayList searchBook(String keyword) { // 도서 검색조회
        ArrayList<Book> searchList = new ArrayList();
//        for (int i = 0; i < list.size(); i++) { // 제네릭타입을 선언하지 않으면 여기서 list.get(i)에서 더이상 book의 private메서드로
//            // 접근하지 못하낟. List list에 저장된 값이 객체인지 뭔지 모르기떄문이다.
//            String title = list.get(i).getTitle();
//            if (title.contains(keyword)) {// 키워드가 for문안의 제목과 같다면( for each문 돌리면 안됨 객체값을 임의
//                //어레이리스트인 searchlist에 담아야하기 떄문 -> 아닌데? 객체값 이용해서 뭐하는것도 아니고 객체만 저장하는거면..인덱스 이용하는거 아니면 되는데
//                searchList.add(list.get(i));
//                // 얘도 for each문으로 바꿔도 되겠다 더 간결할듯.
//            }
//        }
        for(Book b : list){
            if(b.getTitle().contains(keyword)){ // 객체의 제목에 검색하고자 하는 키워드가 있을 떄 list에 추가
                searchList.add(b);
            }
        }
        return searchList;
    }

    Book deleteBook(String title, String author) { // 도서 삭제
        Book removeBook = null;
        for (Book b : list) {
            // 만약에 아무 도서가 없는데 삭제하려고 시도해도 size조건에
            // 안맞아서 실행도 되지 않을것이기 떄문에 괜찮음. 가끔 null일 수 있는 객체를 통해 메서드에 접근하면 에러가 발생하기
            // 때문에 항상 null의 값이 들어와서 실행될 경우라던지 특수한 경우를 생각해 예외처리를 해야함.
            if (title.equals(b.getTitle()) && author.equals(b.getAuthor())) {// 저자명과 도서명이 같을 때 삭제하기 위한 조건.
                removeBook = b;
                list.remove(b); //삭제하고 나서 삭제된 도서를 반환해야하니까 삭제하기 전 위의 코드로 미리 저장해준다.
                return removeBook; //제목과 저자명이 같은 책을 book 객체로 돌려보낸다.
            }
        }

        return null;

    }

    int ascBook() { // 도서 오름차순 정렬
        // 조금 지저분하다. 문자열 크기값을 비교하는 compartToa메서드의 동작원리는 아마도... char배열로 변환하고 첫번쨰 아스키코드값을 비교하는 게 아닐까?
        // 그리고 해쉬코드의 동작원리는 문자열을 char배열로 바꾼 후 모든 아스키코드값을 더하는 것?
        // 그렇다면 위의 원리대로라면 문자열을 오름차순 하기 위해서는 문자열을 char배열로 쪼갠후에 (split) 쪼갠것의 첫번쨰 아스키코드값(숫자크기)만 서로 비교하면 된다.


        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j).getTitle().compareTo(list.get(j + 1).getTitle()) > 0) { // 왼쪽의 값이 더클 경우
                    Book tmp = list.get(j+1); // 작은값
                    list.set(j + 1, list.get(j));
                    list.set(j, tmp);

                }
            }
        }
//        //TreeSet <Book> tr = new TreeSet<>(); // 아래 코드 실행시 트리셋에는 book 인스턴스가 들어갈 수 없다고 한다.
//
//        for ( int i = 0; i)
//        System.out.println(tr);
//        list.clear();
//        for( Book b : tr){
//            list.add(b);
//            System.out.println(b);
//        }

        return 1;

    }
}