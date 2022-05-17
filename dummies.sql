-- 되도록 ssafy로 로그인 하세요!

DELETE FROM `user`;

INSERT INTO `user` 
VALUES 
	("ssafy", "ssafy","김싸피", 24),
    ("coffee", "coffee", "박커피", 36),
    ("galaxy", "galaxy", "이삼성", 22),
    ("reo", "reo", "김레오", 7),
    ("happy","happy","김해피", 6),
    ("choonsik", "choonsik", "김춘식", 2),
    ("winho","winho", "최진호", 30),
    ("oldSubin", "oldSubin", "정수빈", 31),
    ("youngSubin", "youngSubin", "김수빈", 24),
	("apple", "apple", "쿡애플", 65);
    

DELETE FROM `video`;

INSERT INTO `video` 
VALUES	
	("2swcod5RYvU",	"삐약스핏", "상체" ,"(Sub)집에서하는 상체운동!Upper body workout at home", 0),
    ("3TyTGxBNwic","보통사람을 위한 운동채널","하체","(Sub)'스쿼트'를 하지 않고 하체 근육을 키우는 가장 빠른방법!? (feat.허벅지/엉덩이)", 0),
	("4EcIZexNa7A","근력발전소","상체", "(Sub)일반인이'이것'만 알면 상체 프레임과 등근육은 무조건 넓어집니다",0),
	("54tTYO-vU2E","ThankyouBUBU","상체","상체 다이어트 최고의 운동 BEST [팔뚝살/겨드랑이살/등살/가슴어깨라인]",0),
	("7TLk7pscICk","SomiFit","복부","(Sub)누워서하는 5분 복부운동!! 효과보장! (매일 2주만 해보세요!",0),
	("cMkZ6A7wngk","Dano TV","전신","[ENG/ 전신 올인원 운동] 유튜브에서 다이어트 전신운동 찾았어요? 이제 딱 이거 하나만 해요! l diet workoutㅣ다노티비", 0),
	("CYcLODSeC-c",	"권혁 Hulk's TV","전신","Lv.4 층간소음없이 딱! 15분 체지방 100% 녹여버리는 루틴 [Noise Free 15mins Fat Burning Workout]",0),
	("dpBYYEhdofI",	"이지은 다이어트", "하체","(Sub)앞벅지 볼록, 뒷벅지 셀룰라이트, 허벅지 안쪽살 모조리 불태우고:fire: [여리탄탄 일자 허벅지] 되는 7일 루틴",0),
	("GhIpFWzuliA",	"지피티", "하체","(Sub)당신의 16분이 전혀 아깝지 않을 영상.. 하체가 빈약하다면 필수시청", 0),
	("gMaB-fG4u4g",	"ThankyouBUBU", "전신", "전신 다이어트 최고의 운동 [칼소폭 찐 핵핵매운맛]",0),
	("gqR73V3fq2k",	"힙으뜸",	"전신", "힙으뜸 체지방 태우는 전신 운동 15분 루틴 ㅣ15MIN FULL BODY WORKOUT",0),
	("hR1ZgDQqyVI",	"비타민신지니",	"복부", "(Sub):fire:볼록 튀어나온 아랫뱃살:fire:무조건 빠지는 역대급 뱃살폭파운동 (똥배/복부지방)",0),
	("jiHoMmNhVzM",	"이지은 다이어트","복부", "(Sub):diamonds:말랑 출렁이는 뱃살:diamonds:에서 탄력있는 일자복근 만들기",0),
	("kETh8T3it4k",	"힙으뜸",	"복부", "(Sub)(층간소음X, 설명O) 복근운동과 유산소를 한번에:exclamation:️서서하는 복근운동 1탄:fire:",0),
	("KXYi6bI-UPEc","권혁 Hulk's TV", "하체", "(Sub)Lv.5 13분만에 하체 마비시키는 루틴! 근육통100% 옵니다. (누구나 집에서 가능) 13mins intense Legs Workout",0),
	("nz5qsvRgK24",	"Hbro 길환TV", "전신", "[전신 운동] 근육은 늘리고 살은 빼는 홈트 (초급자 추천)",0),
	("PjGcOP-TQPE",	"ThankyouBUBU",	"복부", "11자복근 복부 최고의 운동 [복근 핵매운맛]",0),
	("QqqZH3j_vH0",	"ThankyouBUBU",	"상체", "상체비만 다이어트 최고의 운동 [상체 핵매운맛]",0),
	("sVQqBDBZhmI",	"SomiFit", "복부", "(Sub)복부운동 짧고 굵게! 운동효율 갑! [6 MINS ABS WORKOUT]",0),
	("swRNeYw1JkY",	"ThankyouBUBU",	"전신", "하루 15분! 전신 칼로리 불태우는 다이어트 운동",0),
	("swxfuFCVRYE",	"피지컬갤러리",	"복부","(Sub)빡샘과 함께 운동하자 [필수 코어 운동]",0),
	("tzN6ypk6Sps",	"김강민",	"하체","하체운동이 중요한 이유? 이것만 보고 따라하자 ! [하체운동 교과서]",0),
	("u5OgcZdNbMo",	"GYM종국", "하체", "저는 하체 식주의자 입니다",0),
	("Vx2yxXQ0Pkk",	"힙으뜸",	"상체", "(Sub):sports_medal:요일별운동:sports_medal: 목요일 상체집중 근력운동 15분 루틴!",0);

-- 되도록 코멘트는 지우지 말것
-- 새로 생성 시 subcomment의 foreignkey를 다시 맞춰주어야 한다. 
DELETE FROM `comment`;
ALTER TABLE `comment` AUTO_INCREMENT = 1;

INSERT INTO `comment`  
VALUES	
	(0, "2swcod5RYvU", "배고픈 레오", "배고픈데 운동할 힘이 나겠어?!!!", "reo", NOW()),  
    (0,'QqqZH3j_vH0', '집을 잃은 고라니', '최고의 운동영상', 'ssafy', NOW()),
	(0,'QqqZH3j_vH0', '풀먹는 멧돼지', '최고의 운동영상222222222', 'galaxy', NOW()),
	(0,'QqqZH3j_vH0', '화장하는 사슴', '최고의 운동영상', 'youngSubin', NOW()),
	(0,'gMaB-fG4u4g', '베놈베놈', '와우 쩐다', 'oldSubin', NOW()),
	(0,'gMaB-fG4u4g', '지나가던 아이언맨', '오호라', 'winho', '2017-05-22 05:30:43'),    
	(0,'gMaB-fG4u4g', '헌팅하던 토르', '대박', 'winho', '2015-02-11 06:11:31'),
	(0,'tzN6ypk6Sps', '코딩하는 콘', 'ㅋㅋㅋㅋㅋㅋ', 'apple', '2015-02-11 06:11:31'),
	(0,'tzN6ypk6Sps', '다시 살아난 블랙위도우', '으으 못하겠다', 'choonsik', '2021-02-12 07:11:31'),
	(0,'u5OgcZdNbMo', '알고천재 백준', '최고의 영상!!', 'happy', '2022-02-15 07:21:31'),
	(0,'u5OgcZdNbMo', '더운 침리', '짐종국 최고', 'reo', '2015-02-12 05:11:31'),
	(0,'PjGcOP-TQPE', '추운 엘사', '내일부터 다이어트다', 'galaxy', '2021-03-12 07:11:31'),
	(0,'PjGcOP-TQPE', '국밥먹는 트럼프 ', '아이 라이크 김치', 'ssafy', '2021-03-12 07:11:31'),
	(0,'7TLk7pscICk', '에일리언', '맵다 매워', 'ssafy', '2021-03-12 07:11:31'),
	(0,'7TLk7pscICk', '잠깐 보러온 카이사르', '와우 쩐다', 'galaxy', '2021-03-12 07:11:31'),
	(0,'swxfuFCVRYE', '옆에 있던 부스케츠', '최고의 운동영상', 'ssafy', '2021-04-12 07:11:31'), 
	(0,'2swcod5RYvU', '굿뜨', '굿굿', 'ssafy', '2022-04-19 14:28:50');

DELETE FROM `subcomment`;
ALTER TABLE `subcomment` AUTO_INCREMENT = 1;
INSERT INTO `subcomment`
VALUES
	(0, 1,"배고픈 레오", "배고픈데 운동할 힘이 나겠어?!!!", "reo", NOW()),
    (0, 1,"배고픈 레오", "배고픈데 운동할 힘이 나겠어?!!!", "reo", NOW()),
    (0, 2, "배고픈 레오", "배고픈데 운동할 힘이 나겠어?!!!", "reo", NOW()),
    (0, 2, "배고픈 레오", "배고픈데 운동할 힘이 나겠어?!!!", "reo", NOW()),
    (0, 3,'다시 살아난 블랙위도우', '으으 못하겠다', 'choonsik', '2021-02-12 07:11:31'),
    (0, 3,"배고픈 레오", "배고픈데 운동할 힘이 나겠어?!!!", "reo", NOW()),
	(0, 4, '국밥먹는 트럼프 ', '아이 라이크 김치', 'ssafy', '2021-03-12 07:11:31'),
    (0, 4, '에일리언', '맵다 매워', 'ssafy', '2021-03-12 07:11:31'),
    (0, 5, '잠깐 보러온 카이사르', '와우 쩐다', 'galaxy', '2021-03-12 07:11:31'),
    (0,6, '더운 침리', '짐종국 최고', 'reo', '2015-02-12 05:11:31'),
    (0,6,'코딩하는 콘', 'ㅋㅋㅋㅋㅋㅋ', 'apple', '2015-02-11 06:11:31'),
    (0,7,'베놈베놈', '와우 쩐다', 'oldSubin', NOW()),
	(0,8,'베놈베놈', '와우 쩐다', 'oldSubin', NOW()),
    (0,9,'다시 살아난 블랙위도우', '으으 못하겠다', 'choonsik', '2021-02-12 07:11:31'),
    (0,9,"배고픈 레오", "배고픈데 운동할 힘이 나겠어?!!!", "reo", NOW()),
    (0,10,'코딩하는 콘', 'ㅋㅋㅋㅋㅋㅋ', 'apple', '2015-02-11 06:11:31'),
	(0,10, '더운 침리', '짐종국 최고', 'reo', '2015-02-12 05:11:31'),
	(0,11, '더운 침리', '짐종국 최고', 'reo', '2015-02-12 05:11:31'),
    (0,11, "배고픈 레오", "배고픈데 운동할 힘이 나겠어?!!!", "reo", NOW()),
	(0,12,'옆에 있던 부스케츠', '최고의 운동영상', 'ssafy', '2021-04-12 07:11:31'), 
    (0,12,'에일리언', '맵다 매워', 'ssafy', '2021-03-12 07:11:31'),
    (0,13,'추운 엘사', '내일부터 다이어트다', 'galaxy', '2021-03-12 07:11:31'),
    (0,13,'화장하는 사슴', '최고의 운동영상', 'youngSubin', NOW());

DELETE FROM `like`;
ALTER TABLE `like` AUTO_INCREMENT =1;

INSERT INTO `like`
VALUES
	(0, '7TLk7pscICk',"reo"),
    (0, "2swcod5RYvU","reo"),
    (0, 'QqqZH3j_vH0',"reo"),
    (0, 'QqqZH3j_vH0',"ssafy"),
    (0, 'u5OgcZdNbMo', "ssafy"),
    (0, 'tzN6ypk6Sps', "ssafy"),
    (0, "swxfuFCVRYE", "ssafy"),
    (0,'tzN6ypk6Sps', "coffee"),
    (0,"swxfuFCVRYE", "coffee");

DELETE FROM `follow`;
ALTER TABLE `follow` AUTO_INCREMENT =1;

INSERT INTO `follow`
VALUES
	(0, 'ssafy', 'coffee'),
    (0, 'ssafy', 'galaxy'),
    (0, 'ssafy', 'reo'),
    (0, 'ssafy', 'choonsik'),
	(0, 'ssafy', 'happy'),
    (0, 'ssafy', 'oldSubin'),
    (0, 'ssafy', 'youngSubin'),
    (0, 'ssafy', 'winho'),
    (0, 'coffee', 'galaxy'),
    (0, 'coffee', 'ssafy'),
    (0, 'coffee', 'reo'),
    (0, 'reo', 'choonsik'),
    (0,'reo', 'happy');