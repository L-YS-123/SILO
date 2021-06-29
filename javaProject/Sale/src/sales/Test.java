package sales;

//--------------------------------------------------------------------------------------------------------------------------------------				
			System.out.println("----------------------------------------");
			int totalPrice = 0;

			for(int i = 0; i <list.size(); i++) {
				totalPrice += list.get(i).getPrice();
			}


			int point = (int)(totalPrice * 0.01);

			System.out.println("총 예상 결제 금액: " +totalPrice +"원 입니다.");	
			System.out.println("총 예상 적립 포인트:"+ point +"점입니다."); 

//--------------------------------------------------------------------------------------------------------------------------------------				

			System.out.println("---------------------------------------");


			// 회원 DB에서 point를 read하기

			String readPoint = "select point from member where id = ?";
			pstmt= conn.prepareStatement(readPoint);
			
			pstmt.setString(1, memId);
			rs = pstmt.executeQuery();
			
			int currPoint = 0;
			while(rs.next()) {
				currPoint = rs.getInt("point");
			}
			
			
			System.out.println("현재 사용가능한 포인트: " + currPoint);
			System.out.println("포인트를 사용하시겠습니까? 1. 예 2. 아니오");
			System.out.println("(포인트를 사용할시 현재 결제하시는 상품의 포인트는 적립이 되지 않습니다.)");
			//int answer = Integer.parseInt(scanner.nextLine());
//---------------------------------------------------------------------------------------------------------
			System.out.println("------------------------------------");
			
			//DB에 포인트 적립하기 ->update 하기
			String updatePoint = "update member set point= point + ? where id = ? ";
			pstmt = conn.prepareStatement(updatePoint);
			
			pstmt.setInt(1, point);
			pstmt.setString(2, memId);
			
			result = pstmt.executeUpdate();
			
			
			if(result > 0) {
				System.out.println("업데이트 완료");
			}else {
				System.out.println("업데이트 실패");
			}
			

			System.out.println("포인트가 "+point+"점 적립되어"+ (currPoint+point)+" 점 있습니다.");
			


		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		}
	}
}
	