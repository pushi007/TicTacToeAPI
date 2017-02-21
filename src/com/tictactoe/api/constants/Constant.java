package com.tictactoe.api.constants;

import javax.ws.rs.core.Response.Status.Family;
import javax.ws.rs.core.Response.StatusType;

public enum Constant implements StatusType {
	TOKEN_EXPIRY("token.timeout"), 
	DISCUSS_API("mygov.discuss.api"), 
	GROUP_API("mygov.group.api"), 
	TALK_API("mygov.talk.api"), 
	TASK_API("mygov.task.api"),
	POLL_QUESTION_API("mygov.poll-question.api"),
	POLL_API("mygov.poll.api"), 
	API_KEY("api.key"), 
	API_DESCRIPTION("api.description"), 
	BASIC_AUTHENTICATION_HEADER("Authorization"), 
	TOKEN_AUTHENTICATION_HEADER("X-Auth-Token"), 
	UNAUTHORIZED("UNAUTHORIZED:SC401"), 
	UNAUTHENTICATED("UNAUTHENTICATED:SC402"), 
	TOKEN_INVALID("TOKEN_INVALID:SC403"), 
	TOKEN_MISSING("TOKEN_MISSING:SC404"), 
	INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR:SC500"),
	MENU_UPLOAD_PATH("PATH"), 
	VALIDATION("VALIDATION:SC400"), 
	DEACTIVE("DEACTIVE"), 
	ACTIVE("ACTIVE"),
	DRAFT("DRAFT"),
	SUBMITTED("SUBMITTED"),
	ALLOW_ORIGINS("allow.origins"), 
	CLIENT_ID("myas"), 	
	CLIENT_SECRET("client_secret"),
	GRANT_TYPE("authorization_code"),
	REDIRECT_URI("redirect_uri"),
	URL("https://auth.mygov.in/oauth2/token"),
	PROFILE_URL(""),
	SMS_URL("nic.sms.url"),
	BULK_UPLOAD("PATH"),
	BULK_UPLOADED("NEWPATH"),
	PAGE_SIZE("page.size"),
	YOUTH_ENROLLMENT_EMAIL_SUBJECT("youth.enrollment.email.subject"),
	YOUTH_ENROLLMENT_EMAIL_BODY("youth.enrollment.email.body"),
	YOUTH_ENROLLMENT_SMS_SUBJECT("youth.enrollment.sms.subject"),
	YOUTH_ENROLLMENT_SMS_BODY("youth.enrollment.sms.body"),
	MOBILE_NUMBER_REQUIRED_LENGTH("mobile.number.required.length"),
	AADHAR_NUMBER_REQUIRED_LENGTH("aadhar.number.required.length"),
	FORM_HAS_NO_DATA("form.has.no.data"),
	AADHAR_NUMBER_FIELD_VALIDATION("aadhar.number.field.validation"),
	ADDRESS_FIELD_VALIDATION("address.field.validation"),
	CITY_FIELD_VALIDATION("city.field.validation"),
	FATHERNAME_FIELD_VALIDATION("fathername.field.validation"),
	FULLNAME_FIELD_VALIDATION("fullname.field.validation"),
	LANDMARK_FIELD_VALIDATION("landmark.field.validation"),
	MOTHERNAME_FIELD_VALIDATION("mothername.field.validation"),
	DOB_FIELD_VALIDATION("dob.field.validation"),
	DOB_RANGE_VALIDATION("dob.range.validation"),
	MOBILE_FIELD_VALIDATION("mobile.field.validation"),
	EMAIL_FIELD_VALIDATION("email.field.validation"),
	FATHERNAME_MOTHERNAME_VALIDATION("validate.fathername.or.mothername"),
	FATHERNAME_MOTHERNAME_REQUIRED_VALIDATION("required.fathername.and.mothername"),
	EMAIL_MOBILE_REQUIRED_VALIDATION("required.email.or.mobile"),
	FULLNAME_REQUIRED_VALIDATION("fullname.required.validation"),
	GENDER_REQUIRED_VALIDATION("gender.required.validation"),
	DOB_REQUIRED_VALIDATION("dob.required.validation"),
	STATE_REQUIRED_VALIDATION("state.required.validation"),
	DISTRICT_REQUIRED_VALIDATION("district.required.validation"),
	ADDRESS_REQUIRED_VALIDATION("address.required.validation"),
	FIRSTNAME_REQUIRED_VALIDATION("firstname.required.validation"),
	LASTNAME_REQUIRED_VALIDATION("lastname.required.validation"),
	EMAIL_REQUIRED_VALIDATION("email.required.validation"),
	MOBILE_REQUIRED_VALIDATION("mobile.required.validation"),
	USERNAME_REQUIRED_VALIDATION("username.required.validation"),
	ORGANIZATION_REQUIRED_VALIDATION("organization.required.validation"),
	ROLE_REQUIRED_VALIDATION("role.required.validation"),
	FIRSTNAME_FIELD_VALIDATION("firstname.field.validation"),
	LASTNAME_FIELD_VALIDATION("lastname.field.validation"),
	USERNAME_FIELD_VALIDATION("username.field.validation"),
	ORGANIZATION_FIELD_VALIDATION("organization.field.validation"),
	DESIGNATION_FIELD_VALIDATION("designation.field.validation"),
	ALTERNATEPHONE_FIELD_VALIDATION("alternatenumber.field.validation"),
	ROLE_FIELD_VALIDATION("role.field.validation"),
	BLOCK_FIELD_VALIDATION("block.field.validation"),
	PINCODE_REQUIRED_LENGTH("pincode.required.length"),
	PINCODE_FIELD_VALIDATION("pincode.field.validation"),
	UPLOAD_CSV_FORMAT("upload.csvfile.format"),
	CSV_SPLIT("csv.split"),
	ORGANIZATIONCODE_FIELD_VALIDATION("orgcode.field.validation"),
	ORGANIZATIONDESIGNATION_FIELD_VALIDATION("orgdesignation.field.validation"),
	SMSBODY_FIELD_VALIDATION("smsbody.field.validation"),
	EMAILSUBJECT_FILED_VALIDATION("emailsubject.field.validation"),
	EMAILBODY_FILED_VALIDATION("emailbody.field.validation"),
	API_ERROR_MESSAGE("api.error.message"),
	REJECTED("REJECTED"),
	APPROVED("APPROVED"),
	ROLECODE_REQUIRED_VALIDATION("rolecode.required.validation"), 
	ROLENAME_REQUIRED_VALIDATION("rolename.required.validation"),
	MANAGE_USER_MENU_NAME("usermanagment.menu.name"),
	VIEW_RIGHT("view.right"),
	EDIT_RIGHT("edit.right"),
	DELETE_RIGHT("delete.right"),
	PENDING("PENDING"),
	CLOSED("CLOSED"),
	COMPLETED("COMPLETED"),
	CONSTANT("CONSTANT"),
	DISTRICT_LEVEL("DISTRICT"),
	STATE_LEVEL("STATE"),
	NATIONAL_LEVEL("NATIONAL"),
	UNIT_LEVEL("UNIT"),
	MANAGE_VOLUNTEER_MENU_NAME("manage.volunteer.menu.name"),
	APPROVE_RIGHT("approve.right"),
	MESSAGE_MANAGEMENT_MENU_NAME("message.management.menu.name"),
	APPROVER("APPROVER"),
	REVIEWER("REVIEWER"), ENROLL_VOLUNTEER_MENU_NAME("enroll.volunteer.menu.name"), 
	MINISTRY_LEVEL("MINISTRY"), 
	MANAGE_MENU_NAME("manage.menu.menu.name"),
	MANAGE_GEOGRAPHY_MENU_NAME("manage.geography.menu.name"), 
	MANAGE_ROLE_MENU_NAME("manage.role.menu.name"),
	REJECTED_AND_CLOSED("REJECTEDANDCLOSED"),
	REVIEW_1_APPROVED("REVIEW1APPROVED"),
	REVIEW_2_APPROVED("REVIEW2APPROVED"),
	REVIEW_1_REJECTED("REVIEW1REJECTED"),
	REVIEW_2_REJECTED("REVIEW2REJECTED"),
	REVIEW_1_RESUBMITTED("REVIEW1RESUBMITTED"),
	REVIEW_2_RESUBMITTED("REVIEW2RESUBMITTED"),
	RESUBMITTED("RESUBMITTED"),
	EVENT_TASK("EVENT"),
	ACHIEVEMENT_TASK("ACHIEVEMENT"),
	PHOTO_GALLERY_TASK("PHOTOGALLERY"),
	VIDEO_GALLERY_TASK("VIDEOGALLERY"),
	FULLNAME_FIELD_INVALID("fullname.field.invalid"),
	GENDER_FIELD_INVALID("gender.field.invalid"),
	UPLOAD_ORG_NAME("upload.org.name"),
	CONTENT_UPLOAD_PATH("ContentFileUploadPath"),
	SUCCESS("SUCCESS"),
	PHOTO_GALLERY_PATH("PhotoGalleryPath"),
	CONTENT_UPLOAD_PATH_RELATIVE("ContentFileUploadPathRelative"),
	CONTENT_UPLOAD_PATH_VIRTUAL("ContentFileUploadPathVirtual"),
	VIDEO_GALLERY_PATH("VideoGalleryPath"),
	PHOTO_ITEM_PATH("GalleryItem"),
	PHOTO_GALLERY_PATH_RELATIVE("PhotoGalleryPathRelative"),
	VIDEO_GALLERY_PATH_RELATIVE("VideoGalleryPathRelative"),
	APP_NAME("appname"),
	ITEM_PATH("Item"),
	EMAIL_JOB_NAME("EmailJobName"),
	EMAIL_GROUP("EmailGroup"),
	EMAIL_CRON_EXPRESSION("EmailCronExp"),
	SMS_JOB_NAME("SMSJobName"),
	SMS_GROUP("SMSGroup"),
	SMS_CRON_EXPRESSION("SMSCronExp"),
	BULK_JOB_NAME("BulkJobName"),
	BULK_GROUP("BulkGroup"),
	BULK_CRON_EXPRESSION("BulkCronExp"), 
	EMAIL_ADDRESS_LIST("EmailAddressListCronJobStartStop"), 
	CRON_EMAIL_SUBJECT("CronEmailSubject"), 
	CRON_EMAIL_BODY("CronEmailBody"), 
	CRON_EMAIL_BODY_START("CronEmailBodyStart"), 
	CRON_SMS_SUBJECT("CronSMSSubject"), 
	CRON_SMS_BODY_START("CronSMSBodyStart"),
	CRON_SMS_BODY("CronSMSBody"), 
	CONTENT_UPLOAD_PATH_DESC("ContentUploadPathDescription"),
	CONTENT_UPLOAD_PATH_DESC_VIRTUAL("ContentUploadPathDescriptionVirtual"),
	ROLE_NOT_ASSIGNED("RoleNotAssignedError"),
	STATE_DISTRICT_DEACTIVE("StateDistrictDeactive"),
	SMS_GATEWAY_CHANNEL("SMSGatewayChannel"),
	MESSAGE_TO_REGISTERED_USERS("MessageToRegisteredUser"),
	EMAIL_SUBJECT_TO_REGISTERED_USERS("EmailSubjectToRegisteredUser"),
	ENVIRONMMET("environment");
	

	private String value;

	private Constant(String value) {
		this.value = value;
	}

	private Constant(int code) {
	}

	public String getValue() {
		return value;
	}

	@Override
	public Family getFamily() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getReasonPhrase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getStatusCode() {
		// TODO Auto-generated method stub
		return 0;
	}
}
