package org.example.sivillage.shippingaddress.dto.in;
import lombok.Builder;
import lombok.Getter;
import org.example.sivillage.shippingaddress.domain.ShippingAddress;

@Getter
public class ShippingAddressRequestDto {

    private String addressName;

    private String recipient;

    private String phone;

    private String address;

    private String detailedAddress;

    private String postalCode;

    private boolean defaultAddress;
    
    public ShippingAddress toEntity(ShippingAddressRequestDto shippingAddressRequestDto, String memberUuid) {
        return ShippingAddress.builder()
                .addressName(shippingAddressRequestDto.getAddressName())
                .recipient(shippingAddressRequestDto.getRecipient())
                .phone(shippingAddressRequestDto.getPhone())
                .address(shippingAddressRequestDto.getAddress())
                .detailedAddress(shippingAddressRequestDto.getDetailedAddress())
                .postalCode(shippingAddressRequestDto.getPostalCode())
                .defaultAddress(shippingAddressRequestDto.isDefaultAddress())
                .memberUuid(memberUuid)
                .build();
    }

    public ShippingAddress updateToEntity(ShippingAddressRequestDto shippingAddressRequestDto, ShippingAddress shippingAddress){
        return ShippingAddress.builder()
                .id(shippingAddress.getId())
                .addressName(shippingAddressRequestDto.getAddressName())
                .recipient(shippingAddressRequestDto.getRecipient())
                .phone(shippingAddressRequestDto.getPhone())
                .address(shippingAddressRequestDto.getAddress())
                .detailedAddress(shippingAddressRequestDto.getDetailedAddress())
                .postalCode(shippingAddressRequestDto.getPostalCode())
                .defaultAddress(shippingAddressRequestDto.isDefaultAddress())
                .memberUuid(shippingAddress.getMemberUuid())
                .build();
    }

    public static ShippingAddress updateToDefaultShippingAddress (ShippingAddress shippingAddress, boolean isDefaultAddress) {
        return ShippingAddress.builder()
                .id(shippingAddress.getId())
                .addressName(shippingAddress.getAddressName())
                .recipient(shippingAddress.getRecipient())
                .phone(shippingAddress.getPhone())
                .address(shippingAddress.getAddress())
                .detailedAddress(shippingAddress.getDetailedAddress())
                .postalCode(shippingAddress.getPostalCode())
                .defaultAddress(isDefaultAddress)
                .memberUuid(shippingAddress.getMemberUuid())
                .build();
    }

    public static ShippingAddress deactivateDefaultAddress(ShippingAddress shippingAddress){
        return ShippingAddress.builder()
                .id(shippingAddress.getId())
                .addressName(shippingAddress.getAddressName())
                .recipient(shippingAddress.getRecipient())
                .phone(shippingAddress.getPhone())
                .address(shippingAddress.getAddress())
                .detailedAddress(shippingAddress.getDetailedAddress())
                .postalCode(shippingAddress.getPostalCode())
                .defaultAddress(false)
                .memberUuid(shippingAddress.getMemberUuid())
                .build();
    }


    @Builder
    public ShippingAddressRequestDto(String addressName, String recipient, String phone, String address, String detailedAddress, String postalCode, boolean defaultAddress) {
        this.addressName = addressName;
        this.recipient = recipient;
        this.phone = phone;
        this.address = address;
        this.detailedAddress = detailedAddress;
        this.postalCode = postalCode;
        this.defaultAddress = defaultAddress;
    }


}
