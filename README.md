# SpringFramework Study

# ORM
 > ##### (Object-relational mapping) -> Object를 테이블로 매핑시켜주는 기술

# JPA
 > ##### (java persistent api) -> ORM 기술의 자바 표준

# JDBC
 > ##### 자바 프로그램 안에서 SQL을 실행하기 위한 응용프로그램 인터페이스

# HIBERNATE
 > ##### 관계형데이터베이스에 객체지향개념을 적용하는 ORM 객체관계매핑 중 하나로, 디비와 프로그래밍 언어간의 격차를 해소하기 위해 등장

# API
 > ##### 응용 프로그램에서 사용할 수 있도록 운영체제나 프로그래밍 언어가 제공하는 기능을 제어할 수 있게 만든 인터페이스

# REST API
##### 어느정도 규격화한 API 대표적으로 (REST, SOAP)가 있다 REST API는 Restful한 API
 > Restful 하다는 것은
 > 1. URI는 정보의 자원을 표현해야 한다.
 > 2. 자원에 대한 행위는 HTTP Method(GET, POST, PUT, DELETE)로 표현한다.

# GET
 > ##### 리소스를 조회하고 가져온다. (SELECT)
 > 서버(혹은 DB)의 resource는 클라이언트로 전달만 될 뿐 변경되지 않는다.
 > ex)웹브라우저에http://example.com/exmaple.png를 입력하면 해당 그림 파일이 표시되고, http://example.com/something을 입력하면 서버가 해당 route에 표시되어야 하는 페이지를 찾아 보여준다. 


# POST
 > ##### 리소스를 생성한다. (INSERT)
 > 서버에게 resource를 보내면서 생성해 달라고 요청한다. 예를들어 회원가입을 하면 DB에 새로운 회원정보가 등록되고, 사진을 업로드 하면 그 사진이 웹사이트에 등록된다.

# PUT
 > ##### 리소스를 수정한다. (UPDATE)
 > 서버에게 resource의 업데이트 하거나 resource가 없다면 새로운 resource를 생성해 달라고 요청한다. 회원정보 수정 등에 사용된다.

# DELETE
 > ##### 리소스를 삭제한다. (DELETE)
 > 서버에게 resource의 삭제를 요청합니다.

# CRUD
> 대부분의 컴퓨터 소프트웨어가 가지는 기본적인 데이터 처리 기능<br>
> C = Create <br>
> R = Read <br>
> U = Update <br>
> D = Delete <br>

# URI 와 URL
> 쉽게 이해해보자!<br>
> URI = 제일 큰 개념으로 자원의 위치를 나타내준다<br>
> URL = 자원의 식별자로 웹 에서는 ? 뒤에 나오는 쿼리문으로 이해하자!<br>

# XML을 JSON으로 받아오기
> ##### 일반 String으로 받아오니 디코딩 문제가 발생하여 String으로 받아온걸 URI로 변환하여 이슈를 해결!
>     @Test
>     public void start(){
>        //1. 공공데이터 다운로드
>        RestTemplate rt = new RestTemplate();
>        //serviceKey 인코딩 문제로 URI 객체로 감싸야한다
>        String url = "http://apis.data.go.kr/B551182/rprtHospService/getRprtHospService? serviceKey=tzoFe2PJS55%2FBfRhEvfC8JBK7KNrxnPfJ1Gisq%2FeX7bo%2B%2FjMzT9tMNKS7D%2BhmvjYmmkjoNG%2F2BEVKA3h093OjA%3D%3D&pageNo=1&numOfRows=10&_type=json";
>        URI uri = null;
>        try{
>            uri = new URI(url);
>            ResponseDto dto = rt.getForObject(uri,ResponseDto.class);
>            //System.out.println(dto);
>            List<Item> hospitals = dto.getResponse().getBody().getItems().getItem();
>            for(Item item : hospitals){
>                System.out.println(item.getYadmNm());
>                System.out.println("PCR 여부 : " + item.getPcrPsblYn());
>            }
>        }catch (Exception e){
>            e.printStackTrace();
>        }
>     }
