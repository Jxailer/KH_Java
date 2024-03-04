package kr.kh.app.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.Part;

public class FileUploadUtils {
	
	// 파일 이름을 가져오는 메서드
		public static String getFilename(Part part) {
			/*
			 * 개발자 도구 > 네트워크(전체) > '이름'에서 화면 구성요소 선택 > 해당 구성요소의 Header에 어떤 것이 저장되어있는 지 볼 수 이씀.
			 * - Response Headers, Requsst Headers 등이 있음.
			 * */
			String contentDispositon = part.getHeader("content-disposition");
			String [] items = contentDispositon.split(";"); // content-disposition은 각 값이 ';'로 구분되어있음.
			for(String item : items) {
				// 아이템은 '속성명 = 값' 형태로 구성되어있음.
				if(item.trim().startsWith("filename")) {
					// '='의 뒤, 2번째부터 끝에서 -1번째까지 부분문자열을 추출함. (마지막 따옴표 제외)
					return item.substring(item.indexOf("=") + 2, item.length() - 1); 
				}
			}
			// 파일을 찾지 못하면
			return null;
			
		}
		
		public static String upload(String uploadPath, Part part) {
			String fileName = getFilename(part);						// 저장할 파일 이름을 생성함
			// 네트워크 상에서 서로 모르는 객체를 식별하고 구별하기 위한 문자열을 생성함.
			// 8-4-4-4-12 (총 36자)
			UUID uid = UUID.randomUUID();
			
			// 같은 파일 이름을 다른 유저가 올리더라도 중복되지 않게 하기 위해서
			// - File.separator: 운영 체제마다 다른, 경로간의 구분자를 대신함.
			String filePath = calculatePath(uploadPath) + File.separator + uid + "_" + fileName;	
			
			// 클라이언트가 보내준 파일에서 InputStream으로 읽어와서 서버에 
			try(InputStream is = part.getInputStream();					// inputStream을 통해
				OutputStream os = new FileOutputStream(uploadPath + filePath)){		// outputStream을 통해 빈 파일을 임시로 생성함
				byte [] buffer = new byte[1024 * 4]; 					// 4kb씩 읽어와서 덮어쓰기함.
				
				int readCount;		// 읽어온 개수
				
				// InputStream.read(byte []): 읽어와서 배열에 저장 후 읽어온 개수를 반환함.
				// 읽어온 갯수가 없으면 -1을 리턴함.
				while((readCount = is.read(buffer)) != -1) {
					os.write(buffer, 0, readCount);						// 버퍼에 0번지 부터 읽어온 갯수만큼 파일에 씀.
				}
				return filePath.replace(File.separatorChar, '/');		// 구분자 '\'를 '/'로 교체함.
				
			}catch(Exception e) {
				return null;
			}
		}
		
		// 년/월/일 폴더를 만들어서 해당 경로를 반환함.
		private static String calculatePath(String uploadPath) {
			Calendar cal = Calendar.getInstance();							// 오늘 날짜를 가져옴 
			String yearPath = File.separator + cal.get(Calendar.YEAR);		// (\2024)
			//  new DecimalFormat("00").format() : 두자리 수로 형태를 바꿔줌.
			String monthPath = yearPath + File.separator 
					+ new DecimalFormat("00").format(cal.get(Calendar.MONTH) +1);	// (\2024\03) 월은 0부터 11이기 때문에 +1을 해줘야함.
			String datePath = monthPath + File.separator 
					+ new DecimalFormat("00").format(cal.get(Calendar.DATE));		// (\2024\03\04)
			
			makeDir(uploadPath, yearPath, monthPath, datePath);
			return datePath;
		}
		
		// uploadPath를 기준으로 paths들 폴더가 없으면 폴더를 생성해주는 메서드
		private static void makeDir(String uploadPath, String ... paths) {
			int lastIndex = paths.length - 1;
			
			// 마지막 경로에 해당하는 폳러가 있으면 종료
			if(new File(uploadPath + paths[lastIndex]).exists()) {
				return;
			}
			for (String path : paths) {
				File dir = new File(uploadPath + path);
				if(!dir.exists()) {	// 해당 경로가 존재하지 않으
					dir.mkdir();	// 경로를 만들어냄
				}
			}
		}
}
