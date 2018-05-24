package br.com.accera.core.presentation.ui.helpers.alert;


import br.com.accera.core.domain.behavior.ReleasableMemoryBehavior;

/**
 * The interface Alert helper.
 *
 * @author MAYCON CARDOSO on 15/05/2018.
 */
public interface AlertHelper extends ReleasableMemoryBehavior{
    //==============================================================================================
    // HANDLERS
    //==============================================================================================

    /**
     * Show simple message.
     *
     * @param message the message
     */
    void showSimpleMessage( String message );

    /**
     * Show title message.
     *
     * @param title   the title
     * @param message the message
     */
    void showTitleMessage( String title, String message );

    /**
     * Show error message.
     *
     * @param error the error
     */
    void showErrorMessage( String error );

    /**
     * Show error message.
     *
     * @param title the title
     * @param error the error
     */
    void showErrorMessage( String title, String error );

    /**
     * Show error message.
     *
     * @param throwable the throwable
     */
    void showErrorMessage( Throwable throwable );

    /**
     * Show loading.
     *
     * @param message the message
     */
    void showLoading( String message );

    /**
     * Show loading.
     *
     * @param message the message
     */
    void showLoading( int message );

    /**
     * Hide loading.
     */
    void hideLoading();

    /**
     * Hide keyboard.
     */
    void hideKeyboard();

    /**
     * Show builder.
     *
     * @param builder the builder
     */
    void showBuilder( Builder builder );
    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // BUILDERS
    //==============================================================================================

    /**
     * The type Builder.
     */
    class Builder{
        /**
         * The M alert helper.
         */
        protected AlertHelper mAlertHelper;
        /**
         * The M title.
         */
        protected String mTitle = null;
        /**
         * The M message.
         */
        protected String mMessage = null;
        /**
         * The M positive button.
         */
        protected String mPositiveButton = null;
        /**
         * The M negative button.
         */
        protected String mNegativeButton = null;
        /**
         * The M neutral button.
         */
        protected String mNeutralButton = null;
        /**
         * The M positive handler.
         */
        protected SimpleClickHandler mPositiveHandler = null;
        /**
         * The M negative handler.
         */
        protected SimpleClickHandler mNegativeHandler = null;
        /**
         * The M neutral handler.
         */
        protected SimpleClickHandler mNeutralHandler = null;
        /**
         * The M cancelable.
         */
        protected boolean mCancelable = true;

        /**
         * Instantiates a new Builder.
         *
         * @param mAlertHelper the m alert helper
         */
        public Builder(AlertHelper mAlertHelper) {
            this.mAlertHelper = mAlertHelper;
        }

        /**
         * Sets title.
         *
         * @param mTitle the m title
         * @return the title
         */
        public Builder setTitle(String mTitle) {
            this.mTitle = mTitle;
            return this;
        }

        /**
         * Sets message.
         *
         * @param mMessage the m message
         * @return the message
         */
        public Builder setMessage(String mMessage) {
            this.mMessage = mMessage;
            return this;
        }

        /**
         * Sets positive button.
         *
         * @param mPositiveButton the m positive button
         * @return the positive button
         */
        public Builder setPositiveButton(String mPositiveButton) {
            this.mPositiveButton = mPositiveButton;
            return this;
        }

        /**
         * Sets negative button.
         *
         * @param mNegativeButton the m negative button
         * @return the negative button
         */
        public Builder setNegativeButton(String mNegativeButton) {
            this.mNegativeButton = mNegativeButton;
            return this;
        }

        /**
         * Sets neutral button.
         *
         * @param mNeutralButton the m neutral button
         * @return the neutral button
         */
        public Builder setNeutralButton(String mNeutralButton) {
            this.mNeutralButton = mNeutralButton;
            return this;
        }

        /**
         * Sets positive handler.
         *
         * @param mPositiveHandler the m positive handler
         * @return the positive handler
         */
        public Builder setPositiveHandler(SimpleClickHandler mPositiveHandler) {
            this.mPositiveHandler = mPositiveHandler;
            return this;
        }

        /**
         * Sets negative handler.
         *
         * @param mNegativeHandler the m negative handler
         * @return the negative handler
         */
        public Builder setNegativeHandler(SimpleClickHandler mNegativeHandler) {
            this.mNegativeHandler = mNegativeHandler;
            return this;
        }

        /**
         * Sets neutral handler.
         *
         * @param mNeutralHandler the m neutral handler
         * @return the neutral handler
         */
        public Builder setNeutralHandler(SimpleClickHandler mNeutralHandler) {
            this.mNeutralHandler = mNeutralHandler;
            return this;
        }

        /**
         * Sets cancelable.
         *
         * @param mCancelable the m cancelable
         * @return the cancelable
         */
        public Builder setCancelable(boolean mCancelable) {
            this.mCancelable = mCancelable;
            return this;
        }

        /**
         * Show.
         */
        public void show(){
            mAlertHelper.showBuilder(this);
        }
    }
    //==============================================================================================
    //
    //
    //
    //
    //==============================================================================================
    // HANDLERS
    //==============================================================================================

    /**
     * The interface Simple click handler.
     */
    interface SimpleClickHandler{
        /**
         * On click.
         */
        void onClick();
    }
}
