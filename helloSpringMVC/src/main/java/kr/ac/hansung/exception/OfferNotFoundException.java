package kr.ac.hansung.exception;

public class OfferNotFoundException extends RuntimeException {
    // 예외 객체에서 정보를 저장하고 전달할 수 있게 함
    private int offerId;

    public OfferNotFoundException(int id) {
        this.offerId = id;
    }

    public int getOfferId() {
        return offerId;
    }
}
